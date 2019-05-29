package com.ley.spring.cloud.stream.producer.channel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@EnableBinding({Processor.class})
@Slf4j
public class MessageProducer {


    @Bean
    @InboundChannelAdapter(value = Processor.OUTPUT, poller = {@Poller(fixedDelay = "2000")})
    public MessageSource<Date> timeMessageSource() {
        return () -> new GenericMessage<>(new Date(System.currentTimeMillis()));
    }

    @StreamListener(Processor.INPUT)
    public void receiveFromOutput(Object payload) throws UnsupportedEncodingException {
        if (payload instanceof byte[]) {
            byte[] bytes = (byte[]) payload;
            String content = new String(bytes, "utf-8");
            log.info("content: {}", content);
        }
        log.info("Received: {}", payload);
    }
}
