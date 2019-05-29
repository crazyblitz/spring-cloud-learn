package com.ley.springcloud.stream.rabbit.group.producer;

import com.ley.springcloud.stream.rabbit.sink.SinkOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;


@EnableBinding(value = {Source.class})
@Slf4j
public class MessageSender {

    /**
     * @see org.springframework.integration.scheduling.PollerMetadata
     **/
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = {
            @Poller(fixedDelay = "2000")
    })
    public MessageSource<String> userMessageSource() {
        return () -> new GenericMessage<>("{\"name\":\"刘恩源\",\"age\":\"20\"}");
    }

}
