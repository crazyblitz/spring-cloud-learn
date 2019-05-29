package com.ley.springcloud.consumer.service.impl;

import com.ley.springcloud.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("helloService")
public class HelloServiceImpl implements HelloService{

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String sayHello() {
        return restTemplate.getForObject("http://eureka-provider/hello",
                String.class);
    }
}
