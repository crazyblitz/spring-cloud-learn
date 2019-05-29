package com.ley.springboot.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@PropertySource(value = {"classpath:hello.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8")
@RestController
@Slf4j
public class HelloController {

    @Value(value = "${hello:hello}")
    private String hello;


    @Autowired
    private PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer;

    @GetMapping("/hello")
    public String hello() {
        return hello;
    }
}
