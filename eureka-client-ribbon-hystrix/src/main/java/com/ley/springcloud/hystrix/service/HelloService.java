package com.ley.springcloud.hystrix.service;

import com.ley.springcloud.hystrix.utils.HystrixCommandConfigConstants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("helloService")
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallBack", ignoreExceptions = {HystrixBadRequestException.class},
            commandProperties = {@HystrixProperty(name = HystrixCommandConfigConstants.ExecutionIsolationConstants.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,
                    value = "2000")})
    public String hello() {
        return restTemplate.getForObject("http://eureka-provider/hello",
                String.class);
    }

    protected String helloFallBack() {
        return "hello fall back";
    }
}
