package com.mornd.mail;

import com.mornd.server.pojo.Employee;
import com.mornd.server.pojo.MailConstants;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.table.TableRowSorter;
import java.io.IOException;
import java.util.Date;

/**
 * @author mornd
 * @date 2021/2/23 - 14:11
 * 消息接收
 */
@Component
@Slf4j
public class MailReceiver{
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private MailProperties mailProperties;
    @Resource
    private TemplateEngine templateEngine;
    @Resource
    private RedisTemplate redisTemplate;

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//不指定名称代表创建临时队列
                    exchange = @Exchange(value = MailConstants.MAIL_EXCHANGE_NAME,type = "fanout") //绑定的交换机
            )
    })
    public void handler(Message message, Channel channel){
        Employee employee  = (Employee) message.getPayload();
        log.info("执行mail，employee信息为：{}",employee);

        MessageHeaders headers = message.getHeaders();
        //消息序号
        long tag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        //消息id
        MimeMessage msg = javaMailSender.createMimeMessage();
        HashOperations hashOperations = redisTemplate.opsForHash();
        try {
            if(hashOperations.entries("mail_log").containsKey(msgId)){
                log.error("消息已被消费：{}",msgId);
                /**
                 * 手动确认
                 * tag: 消息序号
                 * multiple：是否确认多余
                 */
                channel.basicAck(tag,false);
                return;
            }
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg);
            //发件人
            mimeMessageHelper.setFrom(mailProperties.getUsername());
            //收件人
            mimeMessageHelper.setTo(employee.getEmail());
            //主题
            mimeMessageHelper.setSubject("入职欢迎邮件");
            //发送日期
            mimeMessageHelper.setSentDate(new Date());
            //邮件内容
            Context context = new Context();
            context.setVariable("name",employee.getName());
            context.setVariable("workId",employee.getWorkId());
            context.setVariable("posName",employee.getPosition().getName());
            context.setVariable("joblevelName",employee.getJoblevel().getName());
            context.setVariable("departmentName",employee.getDepartment().getName());
            context.setVariable("joinDate",employee.getBeginDate());
            String mail = templateEngine.process("mail", context);
            mimeMessageHelper.setText(mail,true);
            //发送邮件
            javaMailSender.send(msg);
            log.info("mail发送成功！");
            //将消息id存入redis中
            hashOperations.put("mail_log",msgId,"ok");
            //手动确认消息
            channel.basicAck(tag,false);
        } catch (Exception e) {
            try {
                /**
                 * 手动确认消息
                 * tag：消息序号
                 * multiple：是否确认多余
                 * requeue：是否退回到队列
                 */
                channel.basicNack(tag,false, true);
            } catch (IOException ex) {
                log.error("邮件发送失败：{}",ex.getMessage());
            }
            log.error("邮件发送失败：{}",e.getMessage());
        }
    }
}
