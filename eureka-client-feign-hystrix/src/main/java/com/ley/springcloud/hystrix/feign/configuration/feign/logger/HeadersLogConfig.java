package com.ley.springcloud.hystrix.feign.configuration.feign.logger;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeadersLogConfig {

    @Bean
    public Logger.Level headersLog() {
        return Logger.Level.HEADERS;
    }
}
