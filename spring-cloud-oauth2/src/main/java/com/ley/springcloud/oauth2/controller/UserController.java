package com.ley.springcloud.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/oauth2")
public class UserController {


    /**
     * 获取授权用户的信息
     *
     * @param user 当前用户
     * @return 授权信息
     */
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
