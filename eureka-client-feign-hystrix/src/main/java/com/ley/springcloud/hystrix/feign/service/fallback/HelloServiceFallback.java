package com.ley.springcloud.hystrix.feign.service.fallback;

import com.ley.springcloud.hystrix.feign.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        log.info("service {},method {},服务降级逻辑", HelloService.class.getName()
                , "hello");
        return "error";
    }
}
