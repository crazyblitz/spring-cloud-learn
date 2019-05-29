package com.ley.springboot.admin;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.ListConfig;
import com.hazelcast.config.MapConfig;
import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableTurbine
@EnableHystrixDashboard
public class AdminServerApplication {

    /**
     * Hazelcast config config.
     *
     * @return the config
     */
    @Bean
    public Config hazelcastConfig() {
        return new Config().setProperty("hazelcast.jmx", "true")
                .addMapConfig(new MapConfig("spring-boot-admin-application-store").setBackupCount(1)
                        .setEvictionPolicy(EvictionPolicy.NONE))
                .addListConfig(new ListConfig("spring-boot-admin-event-store").setBackupCount(1)
                        .setMaxSize(1000));
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
