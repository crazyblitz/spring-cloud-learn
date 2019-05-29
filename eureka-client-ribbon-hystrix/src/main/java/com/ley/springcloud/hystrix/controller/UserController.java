package com.ley.springcloud.hystrix.controller;

import com.ley.springcloud.hystrix.bean.User;
import com.ley.springcloud.hystrix.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * sync call
     **/
    @GetMapping(value = "/hystrix/sync/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * async call
     **/
    @GetMapping(value = "/hystrix/async/users/{id}")
    public User getUserByIdAsync(@PathVariable Integer id) {
        try {
            return userService.getUserByIdAsync(id).get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    /**
     * 响应式编程RxJava
     **/
    @GetMapping(value = "/hystrix/reactive/users/{id}")
    public User getUserByIdReactive(@PathVariable Integer id) {
        List<User> userList = new ArrayList<>(1);
        //进行订阅
        userService.getUserByIdReactive(id).subscribe(user -> {
            userList.add(user);
        });
        Assert.notNull(userList.get(0), "userList[0] is not null");
        return userList.get(0);
    }


    /**
     * 同步调用带请求缓存
     **/
    @GetMapping(value = "/hystrix/cache/users/{id}")
    public User getUserByIdAndCache(@PathVariable Integer id) {
        return userService.getUserByIdAndGroup(id);
    }


    /**
     * 更新,先移除缓存
     **/
    @PostMapping(value = "/hystrix/cache/users")
    public Boolean addUser(@RequestBody User user) {
        log.info("user: {}", user);
        return userService.updateUser(user);
    }

    /**
     * hystrix request collapser(Hystrix请求合并器)
     **/
    @GetMapping(value = "/hystrix/findUserById")
    public User findUserById(@RequestParam Integer id) {
        return userService.find(id);
    }
}
