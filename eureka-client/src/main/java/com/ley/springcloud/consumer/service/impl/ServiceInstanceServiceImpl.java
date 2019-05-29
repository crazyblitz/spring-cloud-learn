package com.ley.springcloud.consumer.service.impl;

import com.ley.springcloud.consumer.bean.ServiceInstance;
import com.ley.springcloud.consumer.service.ServiceInstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "serviceInstanceService")
@Slf4j
public class ServiceInstanceServiceImpl implements ServiceInstanceService {


    @Autowired
    private DiscoveryClient discoveryClient;


    @Override
    public List<ServiceInstance> getInstancesByServiceId(String serviceId) {
        List<ServiceInstance> serviceInstanceEOs = new ArrayList<>();
        List<org.springframework.cloud.client.ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
        if (!CollectionUtils.isEmpty(serviceInstances)) {
            for (org.springframework.cloud.client.ServiceInstance serviceInstance : serviceInstances) {
                serviceInstanceEOs.add(initServiceInstance(serviceInstance));
            }
            //log.debug("serviceInstanceEOs: {}", serviceInstanceEOs);
            return serviceInstanceEOs;
        }
        return null;
    }

    @Override
    public Map<String, List<ServiceInstance>> getAllInstances() {
        List<String> serviceIds = discoveryClient.getServices();
        log.debug("service ids: {}", serviceIds);
        Map<String, List<ServiceInstance>> serviceInstanceEOMap = new HashMap<>(16);
        if (!CollectionUtils.isEmpty(serviceIds)) {
            for (String serviceId : serviceIds) {
                List<ServiceInstance> serviceInstanceEOs = this.getInstancesByServiceId(serviceId);
                serviceInstanceEOMap.put(serviceId, serviceInstanceEOs);
            }
            //log.info("serviceInstanceEOMap: {}",serviceInstanceEOMap);
            return serviceInstanceEOMap;
        }
        return null;
    }


    /**
     * init serviceInstance
     **/
    private ServiceInstance initServiceInstance(org.springframework.cloud.client.ServiceInstance serviceInstance) {
        Assert.notNull(serviceInstance, "org.springframework.cloud.client.ServiceInstance must not null.");
        ServiceInstance serviceInstanceEO = new ServiceInstance();
        serviceInstanceEO.setServiceId(serviceInstance.getServiceId().toLowerCase());
        serviceInstanceEO.setHost(serviceInstance.getHost());
        serviceInstanceEO.setPort(serviceInstance.getPort());
        serviceInstanceEO.setSecure(serviceInstance.isSecure());
        serviceInstanceEO.setUri(serviceInstance.getUri());
        serviceInstanceEO.setMetadata(serviceInstance.getMetadata());
        log.debug("service instance eo: {}", serviceInstanceEO);
        return serviceInstanceEO;
    }
}
