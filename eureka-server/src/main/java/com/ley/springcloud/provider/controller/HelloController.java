package com.ley.springcloud.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HelloController {

    public static final String HELLO_WORLD = "Hello World!";


    @Resource
    private Registration registration;

    @Autowired
    private ServiceRegistry serviceRegistry;

    /**
     * test eureka-client-ribbon model ribbon retry
     * <br/>
     **/
    @GetMapping("/hello")
    public String index() {
        log.info("load balanced service instance meta: {}", registration.getMetadata());
        log.info("load balanced host: {},port: {},service id: {}", registration.getHost(), registration.getPort(), registration.getServiceId());
        log.info("service id: {}", registration.getServiceId());
        log.info("service registry: {}", serviceRegistry.getStatus(registration));
        return HELLO_WORLD;
    }


}
