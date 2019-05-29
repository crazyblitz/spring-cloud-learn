package com.ley.springcloud.swagger;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceASwaggerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceASwaggerApplication.class).web(true).run(args);
    }
}