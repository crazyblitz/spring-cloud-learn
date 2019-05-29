package com.ley.springcloud.feign.controller;

import com.ley.springcloud.feign.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private RefactorHelloService refactorHelloService;

    @GetMapping("/feign/hello")
    public String hello() {
        return refactorHelloService.hello() + "feign";
    }

}
