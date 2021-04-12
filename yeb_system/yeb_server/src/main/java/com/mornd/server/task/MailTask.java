package com.mornd.server.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mornd.server.pojo.Employee;
import com.mornd.server.pojo.MailConstants;
import com.mornd.server.pojo.MailLog;
import com.mornd.server.service.EmployeeService;
import com.mornd.server.service.MailLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mornd
 * @date 2021/3/3 - 12:10
 * 邮件发送定时任务
 */
@Slf4j
@Component
@EnableScheduling
public class MailTask {
    @Resource
    private MailLogService mailLogService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 邮件发送定时任务
     * 每10s执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask(){
        log.info("邮件定时任务正在执行...");
        List<MailLog> mailLogs = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0).
                lt("try_time", LocalDateTime.now()));
        mailLogs.forEach(mailLog -> {
            //如果重试次数超过3次，更新状态为投递失败，不再重试
            if(3 <= mailLog.getCount()){
                mailLogService.update(new UpdateWrapper<MailLog>().set("status",2).eq("msg_id",mailLog.getMsgId()));
            }
            mailLogService.update(new UpdateWrapper<MailLog>().set("count",mailLog.getCount()+1).set("update_time",LocalDateTime.now()).
                    set("try_time",LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT)).eq("msg_id",mailLog.getMsgId()));
            Employee employee = employeeService.getEmployeeById(mailLog.getEId()).get(0);
            //重新发送消息
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME,MailConstants.MAIL_ROUTING_KEY_NAME,
                    employee,new CorrelationData(mailLog.getMsgId()));
        });
    }
}
