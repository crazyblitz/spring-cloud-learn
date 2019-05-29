package com.ley.springcloud.consumer.controller;


import com.ley.springcloud.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/ribbon-consumer")
    public String helloConsumer() {
        return helloService.sayHello();
    }

}
