package com.ley.springcloud.stream.rabbit.sink;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * sink output
 **/
public interface SinkOutput {

    String OUTPUT = "input";

    @Output(SinkOutput.OUTPUT)
    MessageChannel output();
}
