package com.ley.springcloud.feign.service;

import com.ley.springcloud.feign.api.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "eureka-feign-server")
public interface RefactorHelloService extends HelloService {
}
