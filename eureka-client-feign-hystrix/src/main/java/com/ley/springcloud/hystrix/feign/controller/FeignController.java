package com.ley.springcloud.hystrix.feign.controller;

import com.ley.springcloud.hystrix.feign.bean.User;
import com.ley.springcloud.hystrix.feign.service.HelloService;
import com.ley.springcloud.hystrix.feign.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FeignController {

    @Resource
    private HelloService helloService;

    @Resource
    private UserService userService;

    @GetMapping("/hystrix/feign/hello")
    public String hello() {
        return helloService.hello();
    }


    @GetMapping("/feign/users/{id}")
    public User user(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/feign/users1/{ids}")
    public List<User> users(@PathVariable String ids) {
        return userService.listUsers(ids);
    }
}
