package com.mornd.server.config;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mornd.server.pojo.MailLog;
import com.mornd.server.service.MailLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author mornd
 * @date 2021/3/3 - 11:49
 */
@Configuration
@Slf4j
public class RabbitMQConfig {
    @Resource
    private CachingConnectionFactory cachingConnectionFactory;
    @Resource
    private MailLogService mailLogService;

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        /**
         * 消息确认回调，确认消息是否到达borker
         * data: 消息唯一标识
         * ack: 确认结果
         * cause: 失败原因
         */
        rabbitTemplate.setConfirmCallback((data,ack,cause) -> {
            String msgId = data.getId();
            if(ack){
                log.info("消息发送成功！msgId:{}",msgId);
                //更新数据库
                mailLogService.update(new UpdateWrapper<MailLog>().set("status",1).eq("msg_id",msgId));
            } else{
                log.error("消息发送失败！");
            }
        });

        /**
         * 消息失败回调，比如router不到queue时回调
         * msg：消息主题
         * repCode：响应码
         * reText：相应描述
         * exchange：交换机
         * routingKey：路由键
         */
        rabbitTemplate.setReturnCallback((msg,repCode,repText,exchange,routingKey) -> {
            log.error("消息发送至queue时失败！",msg.getBody());
        });
        return rabbitTemplate;
    }
}
