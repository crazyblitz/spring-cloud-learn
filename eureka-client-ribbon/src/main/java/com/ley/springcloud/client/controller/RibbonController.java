package com.ley.springcloud.client.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.loadbalancer.IRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Slf4j
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private PropertiesFactory propertiesFactory;


    @GetMapping("/ribbon/hello")
    public String hello(HttpServletRequest request) {
        ServiceInstance instance = loadBalancerClient.choose("eureka-provider");
//        String result = restTemplate.getForObject("http://eureka-provider/hello",
//                String.class);
        log.info("instance {}:{} ", instance.getHost(), instance.getPort());
        log.info("propertiesFactory: {}", propertiesFactory.getClassName(IRule.class, "eureka-provider"));
        return "loadbalance server host is " + instance.getHost() + ":port is " + instance.getPort();
    }
}
