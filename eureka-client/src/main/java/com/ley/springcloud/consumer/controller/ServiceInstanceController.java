package com.ley.springcloud.consumer.controller;

import com.ley.springcloud.consumer.bean.ServiceInstance;
import com.ley.springcloud.consumer.service.ServiceInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ServiceInstanceController {

    @Autowired
    @Qualifier("serviceInstanceService")
    private ServiceInstanceService serviceInstanceService;

    @GetMapping(value = "/instances/{serviceId}")
    public List<ServiceInstance> getInstancesByServiceId(@PathVariable String serviceId) {
        return serviceInstanceService.getInstancesByServiceId(serviceId);
    }

    @GetMapping(value = "/instances")
    public Map<String, List<ServiceInstance>> getAllInstances() {
        return serviceInstanceService.getAllInstances();
    }
}
