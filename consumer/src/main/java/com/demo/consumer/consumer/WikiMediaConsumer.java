package com.demo.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikiMediaConsumer {

    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumeMessage(String msg) {
        log.info("Consumed message is : {}", msg);
    }
}
