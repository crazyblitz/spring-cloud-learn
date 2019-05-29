package com.ley.springboot.ribbon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon-client")
@Slf4j
public class RibbonClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String ribbonClient() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("ribbon-server");
        Assert.notNull(serviceInstance, "service instance need no null");
        log.info("current service instance is: {},uri: {}", serviceInstance.getServiceId(), serviceInstance.getUri());
        String result = restTemplate.getForObject("http://ribbon-server/ribbon-server/index/",
                String.class);
        return result;
    }
}
