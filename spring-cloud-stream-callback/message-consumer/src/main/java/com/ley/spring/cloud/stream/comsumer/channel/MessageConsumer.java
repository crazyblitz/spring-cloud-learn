package com.ley.spring.cloud.stream.comsumer.channel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({Processor.class})
@Slf4j
public class MessageConsumer {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        log.info("Received: {}", payload);
        return "consumer message " + payload + " success.";
    }
}
