package com.ley.springcloud.feign.server.controller;

import com.ley.springcloud.feign.api.HelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloService {

    @Override
    public String hello() {
        return "HELLO WORLD!";
    }
}
