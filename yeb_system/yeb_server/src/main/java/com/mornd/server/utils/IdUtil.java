package com.mornd.server.utils;

import java.util.UUID;

/**
 * @author mornd
 * @date 2021/2/6 - 11:58
 * uuid工具类
 */
public class IdUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
