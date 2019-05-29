package com.ley.springcloud.provider.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * load balanced aspect
 **/

@Slf4j
@Aspect
@Component
public class LoadBalancedLogAspect {

    private static final String POINTCUT = "execution(* com.ley.springcloud.*.controller.*.*(..))";

    @Autowired
    private DiscoveryClient discoveryClient;

    @Pointcut(value = LoadBalancedLogAspect.POINTCUT)
    protected void pointcut() {

    }


    @Before(value = "pointcut()")
    public void beforeLog(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        Signature signature = joinPoint.getSignature();
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        log.info("load balanced service instance meta: {}", serviceInstance.getMetadata());
        log.info("load balanced host: {},port: {},service id: {},target: {},signature: {}", serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getServiceId(),
                target, signature);
    }
}
