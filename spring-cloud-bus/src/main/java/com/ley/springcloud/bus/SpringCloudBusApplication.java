package com.ley.springcloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding
@SpringBootApplication
public class SpringCloudBusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusApplication.class, args);
    }
}
