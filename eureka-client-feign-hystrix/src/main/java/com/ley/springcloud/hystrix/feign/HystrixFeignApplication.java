package com.ley.springcloud.hystrix.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients(basePackages = "com.ley.springcloud.hystrix.feign.service")
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class HystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignApplication.class,args);
    }
}
