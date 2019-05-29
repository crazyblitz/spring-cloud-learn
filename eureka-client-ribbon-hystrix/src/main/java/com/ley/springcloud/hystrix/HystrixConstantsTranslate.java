package com.ley.springcloud.hystrix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class HystrixConstantsTranslate {

    public static void main(String[] args) {
        List<String> hystrixProperties = Arrays.asList(new String[]{"metrics.rollingStats.numBuckets",
                "metrics.rollingPercentile.enabled", "metrics.rollingPercentile.timeInMilliseconds", "metrics.rollingPercentile.numBuckets",
                "metrics.rollingPercentile.bucketSize", "metrics.healthSnapshot.intervalInMilliseconds", "requestCache.enabled",
                "requestLog.enabled", "maxRequestsInBatch", "timerDelayInMilliseconds", "requestCache.enabled",
                "coreSize", "maximumSize", "maxQueueSize", "queueSizeRejectionThreshold",
                "keepAliveTimeMinutes", "allowMaximumSizeToDivergeFromCoreSize",
                "metrics.rollingStats.timeInMilliseconds", "metrics.rollingStats.numBuckets"
        });
        hystrixProperties = translateList(hystrixProperties);
        for (String hystrixProperty : hystrixProperties) {
            System.out.println(hystrixProperty);
        }
        System.out.println(hystrixProperties.size());
    }


    protected static String translate(String hystrixProperty) {
        String propertyPrefix = "public static final String ";
        //log.info(hystrixProperty);
        String realHystrixProperty = hystrixProperty.replace(".", "_").toUpperCase();
        //log.info(realHystrixProperty);
        realHystrixProperty = propertyPrefix + realHystrixProperty + " = " + "\"" + hystrixProperty + "\"" + ";";
        return realHystrixProperty;
    }


    protected static List<String> translateList(List<String> hystrixProperties) {
        if (!CollectionUtils.isEmpty(hystrixProperties)) {
            List<String> properties = new ArrayList<>();
            for (String hystrixProperty : hystrixProperties) {
                properties.add(translate(hystrixProperty));
            }
            return properties;
        }
        return null;
    }
}
