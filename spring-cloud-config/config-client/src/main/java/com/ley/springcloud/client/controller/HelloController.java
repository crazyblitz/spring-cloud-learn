package com.ley.springcloud.client.controller;

import com.ley.springcloud.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class HelloController {

    @Value("${from:default}")
    private String from;


    @Value("${spring.user.name}")
    private String name;

    @Value("${spring.user.age:0}")
    private Integer age;

    @Value("${spring.user.address}")
    private String address;


    @Autowired
    private Environment environment;

    @GetMapping("/from")
    public String from() {
        log.info("profile {},name {},uri {}", environment.getProperty("spring.cloud.config.profile"),
                environment.getProperty("spring.application.name"),
                environment.getProperty("spring.cloud.config.uri"));
        log.info(from);
        return from;
    }


    @GetMapping("/user")
    public User user() {
        User user=new User();
        user.setAge(age);
        user.setAddress(address);
        user.setName(name);
        return user;
    }
}
