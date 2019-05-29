package com.ley.springcloud.registry.config;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.EurekaServerConfigBean;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
public class EurekaStateChangeListener {

    /**
     * 服务下线事件
     **/
    @EventListener
    public void listenServerCanceled(EurekaInstanceCanceledEvent canceledEvent) {
        log.info("server id: {},app name: {} 下线", canceledEvent.getServerId(),
                canceledEvent.getServerId());
    }


    /**
     * 服务注册事件
     **/
    @EventListener
    public void listenServerRegister(EurekaInstanceRegisteredEvent registeredEvent) {
        InstanceInfo instanceInfo = registeredEvent.getInstanceInfo();
        log.info("server instance app name: {},host: {},instance id: {} register",
                instanceInfo.getAppName(), instanceInfo.getHostName(), instanceInfo.getInstanceId());
    }

    /**
     * 服务续约事件
     **/
    @EventListener
    public void listenServerRenewedEvent(EurekaInstanceRenewedEvent renewedEvent) {
        log.info("server instance id: {},app name: {},instance info: {} 进行续约", renewedEvent.getServerId(),
                renewedEvent.getAppName(), renewedEvent.getInstanceInfo());
    }


    /**
     * Eureka server启动事件
     **/
    @EventListener
    public void listenServerStart(EurekaServerStartedEvent startedEvent) {
        log.info("server: {} 启动,时间: {}", startedEvent.getSource(), startedEvent.getTimestamp());
    }


    /**
     * 注册中心启动事件
     **/
    @EventListener
    public void listenRegistryAvailable(EurekaRegistryAvailableEvent registryAvailableEvent) {
        EurekaServerConfigBean serverConfigBean = (EurekaServerConfigBean) registryAvailableEvent.getSource();
        log.info("注册中心启动: {}", serverConfigBean);
    }
}
