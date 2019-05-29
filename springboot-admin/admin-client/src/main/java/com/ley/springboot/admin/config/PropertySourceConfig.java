package com.ley.springboot.admin.config;

import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@ConditionalOnClass(PropertyResourceConfigurer.class)
public class PropertySourceConfig {

    /**
     * @see PropertySourcesPlaceholderConfigurer
     **/
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return propertySourcesPlaceholderConfigurer;
    }
}
