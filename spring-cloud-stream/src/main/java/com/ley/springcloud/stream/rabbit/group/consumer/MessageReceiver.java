package com.ley.springcloud.stream.rabbit.group.consumer;

import com.ley.springcloud.stream.rabbit.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(value = {Sink.class})
@Slf4j
public class MessageReceiver {

    /**
     * 使用{@link StreamListener}信息消费消息,支持默认对象格式转换
     *
     * @see StreamListener
     **/
    @StreamListener(Sink.INPUT)
    public void receiveUserStream(User user) {
        log.info("Received: {}", user);
    }
}
