package com.ley.springcloud.hystrix.feign.configuration.feign.logger;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicLogConfig {

    @Bean
    public Logger.Level basicLog() {
        return Logger.Level.BASIC;
    }
}
