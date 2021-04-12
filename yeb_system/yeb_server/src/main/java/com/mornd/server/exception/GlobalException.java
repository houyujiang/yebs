package com.mornd.server.exception;

import com.mornd.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author mornd
 * @date 2021/2/3 - 20:09
 * 全局异常处理
 */
//@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public RespBean mySQLException(Exception e){
        //sql表数据关联异常
        if(e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据已和其他数据表关联，操作失败！");
        }
        //SQL异常
        if(e instanceof SQLException){
            return RespBean.error("SQL异常，操作失败！");
        }
        return RespBean.error("操作异常，请重试！");
    }
}
