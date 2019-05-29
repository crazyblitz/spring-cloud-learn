package com.ley.springcloud.provider.listener;

import com.ley.springcloud.provider.utils.RandomServerPortPropertySource;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * random server port application environment prepared event listener
 * **/
public class RandomServerPortApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        applicationEnvironmentPreparedEvent.getEnvironment().getPropertySources().addLast(new RandomServerPortPropertySource());
    }
}
