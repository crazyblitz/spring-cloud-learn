package com.ley.springcloud.consumer.service;

import com.ley.springcloud.consumer.bean.ServiceInstance;

import java.util.List;
import java.util.Map;

/**
 * ServiceInstance service
 **/
public interface ServiceInstanceService {

    /**
     * get service instance by serviceId
     *
     * @see ServiceInstance
     * @see org.springframework.cloud.client.ServiceInstance
     **/
    List<ServiceInstance> getInstancesByServiceId(String serviceId);

    /**
     * get all service instances
     *
     * @see ServiceInstance
     * @see org.springframework.cloud.client.ServiceInstance
     **/
    Map<String, List<ServiceInstance>> getAllInstances();
}
