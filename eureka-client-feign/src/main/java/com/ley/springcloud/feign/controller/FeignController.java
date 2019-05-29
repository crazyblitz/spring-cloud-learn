package com.ley.springcloud.feign.controller;

import com.ley.springcloud.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeignController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/feign/hello")
    public String hello() {
        return helloService.hello();
    }
}
