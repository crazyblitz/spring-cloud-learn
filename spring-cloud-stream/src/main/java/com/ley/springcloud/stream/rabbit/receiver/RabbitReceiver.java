package com.ley.springcloud.stream.rabbit.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.io.UnsupportedEncodingException;

//@EnableBinding(Sink.class)
@Slf4j
public class RabbitReceiver {

    /**
     * receiver listen input stream and receiver message from
     * RabbitMQ message consumer
     **/
    //@StreamListener(Sink.INPUT)
    public void receiver(Object payload) throws UnsupportedEncodingException {
        log.info("Received: {}", new String(payload.toString().getBytes(), "UTF-8"));
    }
}
