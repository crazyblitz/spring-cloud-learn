package com.ley.springcloud.stream.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ley.springcloud.stream.rabbit.group.producer")
public class StreamRabbitSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitSenderApplication.class, args);
    }
}
