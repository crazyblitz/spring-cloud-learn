package com.ley.springcloud.hystrix.feign.service;

import com.ley.springcloud.hystrix.feign.bean.User;
import com.ley.springcloud.hystrix.feign.configuration.feign.logger.FullLogConfig;
import com.ley.springcloud.hystrix.feign.service.fallback.HelloServiceFallback;
import com.ley.springcloud.hystrix.feign.service.fallback.UserServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "eureka-provider", fallback = UserServiceFallback.class, configuration = FullLogConfig.class)
public interface UserService {

    @GetMapping(value = "/users/{id}")
    User getUserById(@PathVariable(name = "id") Integer id);


    @GetMapping(value = "/users1/{ids}")
    List<User> listUsers(@PathVariable(name = "ids") String ids);

}
