package com.ley.springboot.ribbon.config;

import com.ley.springboot.ribbon.bean.Health;
import com.ley.springboot.ribbon.bean.HealthProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@EnableConfigurationProperties(value = {HealthProperties.class})
@ConditionalOnClass(Health.class)
public class EurekaHealthConfiguration {

    private final HealthProperties healthProperties;

    public EurekaHealthConfiguration(HealthProperties healthProperties) {
        this.healthProperties = healthProperties;
        System.out.println("healthProperties: "+healthProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public Health health() {
        Health health = new Health();
        health.setId(healthProperties.getId());
        health.setState(healthProperties.getState());
        health.setTimestamp(new Date(System.currentTimeMillis()));
        System.out.println("health: "+health);
        return health;
    }
}
