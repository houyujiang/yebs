package com.mornd.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author mornd
 * @date 2021/1/26 - 19:34
 * 主启动类
 */

@EnableCaching
@SpringBootApplication
@MapperScan({"com.mornd.server.mapper"})
public class YebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YebServerApplication.class, args);
    }

}
