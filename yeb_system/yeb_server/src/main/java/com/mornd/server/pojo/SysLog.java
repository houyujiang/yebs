package com.mornd.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mornd
 * @date 2021/3/3 - 14:10
 * 系统日志实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_log")
@Accessors(chain = true)
@ApiModel(value = "系统日志",description = "")
public class SysLog implements Serializable {
    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("访问用户名")
    private String userName;

    @ApiModelProperty("类名")
    private String className;

    @ApiModelProperty("方法名")
    private String method;

    @ApiModelProperty("访问时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date visitTime;

    @ApiModelProperty("操作时长")
    private Long executionTime;

    @ApiModelProperty("方法参数")
    private String param;

    @ApiModelProperty("IP地址")
    private String ip;

    @ApiModelProperty("请求URL")
    private String url;

    @ApiModelProperty("获取操作系统和浏览器信息")
    private String osAndBrowser;

    @ApiModelProperty("sessionId")
    private String sessionId;

    @ApiModelProperty("请求方式")
    private String reqMethod;

    @ApiModelProperty("是否是Ajax请求")
    private String isAjax;

    @ApiModelProperty("访问用户id")
    private Integer userId;

    @ApiModelProperty("方法返回值")
    private String result;

    @ApiModelProperty("异常信息")
    private String exception;
}
