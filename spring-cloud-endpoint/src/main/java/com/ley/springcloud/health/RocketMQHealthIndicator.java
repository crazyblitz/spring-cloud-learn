package com.ley.springcloud.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @see HealthIndicator
 * @see org.springframework.boot.actuate.health.Status
 * @see Health
 * @see Health#details
 **/
public class RocketMQHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        //检查条件
        return 1;
    }
}
