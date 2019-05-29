package com.ley.springcloud.provider;

import com.ley.springcloud.provider.listener.RandomServerPortApplicationEnvironmentPreparedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProviderApplication {

    public static void main(String[] args) {
        initSpringApplication(args);
        //SpringApplication.run(EurekaProviderApplication.class, args);
    }


    /**
     * @see RandomServerPortApplicationEnvironmentPreparedEventListener
     **/
    private static void initSpringApplication(String[] args) {
        SpringApplication application = new SpringApplication(EurekaProviderApplication.class);
        application.addListeners(new RandomServerPortApplicationEnvironmentPreparedEventListener());
        application.run(args);
    }
}
