package com.ley.springcloud.stream.rabbit.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ley.springcloud.stream.rabbit.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.io.IOException;

/**
 * 使用Spring Integration 消费消息
 **/
//@EnableBinding(Sink.class)
@Slf4j
public class MessageReceiverUser {

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receiveUser(User user) {
        log.info("Received: {}", user);
    }

    /**
     * 消息消息进行json格式转换
     **/
    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public User transform(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(message, User.class);
        return user;
    }

}
