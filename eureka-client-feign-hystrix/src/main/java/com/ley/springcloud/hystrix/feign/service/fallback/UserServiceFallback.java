package com.ley.springcloud.hystrix.feign.service.fallback;

import com.ley.springcloud.hystrix.feign.bean.User;
import com.ley.springcloud.hystrix.feign.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserServiceFallback implements UserService {

    @Override
    public User getUserById(Integer id) {
        log.info("服务降级");
        return null;
    }

    @Override
    public List<User> listUsers(String ids) {
        log.info("服务降级");
        return null;
    }
}
