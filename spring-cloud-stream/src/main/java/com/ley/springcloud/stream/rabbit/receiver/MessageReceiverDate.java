package com.ley.springcloud.stream.rabbit.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

//@EnableBinding(Sink.class)
@Slf4j
public class MessageReceiverDate {

    /**
     * 使用Spring Integration进行消费消息.
     **/
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object payload) {
        log.info("Received: {}", payload);
    }
}
