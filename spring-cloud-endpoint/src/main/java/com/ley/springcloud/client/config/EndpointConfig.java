package com.ley.springcloud.client.config;

import com.ley.springcloud.endpoint.PersonEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class EndpointConfig {

    @Bean
    public static Endpoint<Map<String, Object>> personEndpoint() {
        return new PersonEndpoint();
    }
}
