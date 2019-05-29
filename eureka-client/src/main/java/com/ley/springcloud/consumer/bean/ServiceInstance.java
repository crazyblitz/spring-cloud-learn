package com.ley.springcloud.consumer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.Map;

/**
 * @see org.springframework.cloud.client.ServiceInstance
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInstance {

    /**
     * service id is must lowercase
     **/
    private String serviceId;

    private String host;

    private Integer port;

    private Map<String, String> metadata;

    private Boolean secure;

    private URI uri;
}
