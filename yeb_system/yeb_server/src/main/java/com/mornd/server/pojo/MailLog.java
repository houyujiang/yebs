package com.mornd.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author mornd
 * @date 2021/3/3 - 11:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_mail_log")
@ApiModel(value = "邮件日志实体类",description = "")
public class MailLog implements Serializable {

    @ApiModelProperty("消息id")
    @TableId(value = "msg_id",type = IdType.UUID)
    private String MsgId;

    @ApiModelProperty("接收员工id")
    private Integer eId;

    @ApiModelProperty("状态(0:消息投递中1:投递成功2:投递失败)")
    private Integer status;

    @ApiModelProperty("路由键")
    private String routeKey;

    @ApiModelProperty("交换机")
    private String exchange;

    @ApiModelProperty("重试次数")
    private Integer count;

    @ApiModelProperty("重试时间")
    private LocalDateTime tryTime;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
