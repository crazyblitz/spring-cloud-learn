package com.ley.springcloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-provider")
public interface HelloService {

    @GetMapping("/hello")
    String hello();
}
