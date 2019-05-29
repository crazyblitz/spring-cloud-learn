package com.ley.springcloud.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka registry center application
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegistryApplication.class, args);
    }
}
