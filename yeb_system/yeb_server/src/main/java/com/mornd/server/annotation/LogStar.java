package com.mornd.server.annotation;

/**
 * @author mornd
 * @date 2021/3/3 - 14:15
 */

import java.lang.annotation.*;

/**
 * @author mornd
 * @date 2021/1/13 - 15:46
 * 系统日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Inherited
public @interface LogStar {
    String value() default "未标注";
    boolean simple() default false;
}
