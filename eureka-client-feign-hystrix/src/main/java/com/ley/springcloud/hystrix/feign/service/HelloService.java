package com.ley.springcloud.hystrix.feign.service;

import com.ley.springcloud.hystrix.feign.configuration.feign.logger.FullLogConfig;
import com.ley.springcloud.hystrix.feign.service.fallback.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provider", fallback = HelloServiceFallback.class, configuration = FullLogConfig.class)
public interface HelloService {

    @GetMapping("/hello")
    String hello();
}
