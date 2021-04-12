package com.mornd.server.pojo;

/**
 * @author mornd
 * @date 2021/3/3 - 11:17
 * 消息状态
 */
public interface MailConstants {
    //消息投递中
    Integer DELIVERING = 0;
    //消息投递成功
    Integer SUCESS = 1;
    //消息投递失败
    Integer FAILURE = 2;
    //最大重试次数
    Integer MAX_TRY_COUNT = 3;
    //消息超时时间
    Integer MSG_TIMEOUT = 1;
    //队列
    String MAIL_QUEUE_NAME = "mail.queue";
    //交换机
    String MAIL_EXCHANGE_NAME = "mail.exchange";
    //路由键
    String MAIL_ROUTING_KEY_NAME = "mail.routing.key";

}
