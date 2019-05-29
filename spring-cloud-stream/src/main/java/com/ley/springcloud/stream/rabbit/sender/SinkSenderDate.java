package com.ley.springcloud.stream.rabbit.sender;

import com.ley.springcloud.stream.rabbit.sink.SinkOutput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Sink sender date
 **/
//@EnableBinding(value = {SinkOutput.class})
public class SinkSenderDate {

    /**
     * @see org.springframework.integration.scheduling.PollerMetadata
     **/
    @Bean
    @InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = {
            @Poller(fixedDelay = "2000")
    })
    public MessageSource<Date> timerMessageSource() {
        return () -> new GenericMessage<>(new Date(System.currentTimeMillis()));
    }


    /**
     * need public
     *
     * @see Transformer
     **/
    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public Object transfrom(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

}
