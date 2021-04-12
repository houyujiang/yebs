package com.mornd.mail;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@EnableRabbit
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YebMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(YebMailApplication.class, args);
    }

}
