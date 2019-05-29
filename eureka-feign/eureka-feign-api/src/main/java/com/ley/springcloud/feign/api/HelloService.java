package com.ley.springcloud.feign.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface HelloService {

    @GetMapping("/hello")
    String hello();
}
