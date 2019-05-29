package com.ley.springcloud.stream.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @see org.springframework.cloud.stream.binder.rabbit.properties.RabbitBinderConfigurationProperties
 * @see org.springframework.cloud.stream.config.BindingProperties
 * @see org.springframework.cloud.stream.binder.ConsumerProperties
 * @see org.springframework.cloud.stream.binder.ProducerProperties
 **/
@SpringBootApplication
@ComponentScan("com.ley.springcloud.stream.rabbit.group.consumer")
public class StreamRabbitReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitReceiverApplication.class, args);
    }
}
