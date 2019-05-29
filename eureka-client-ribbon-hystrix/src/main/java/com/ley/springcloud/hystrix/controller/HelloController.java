package com.ley.springcloud.hystrix.controller;

import com.ley.springcloud.hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    @Qualifier("helloService")
    private HelloService helloService;


    @GetMapping("/hystrix/hello")
    public String hell() {
        return helloService.hello();
    }
}
