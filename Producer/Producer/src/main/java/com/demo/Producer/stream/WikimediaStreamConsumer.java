package com.demo.Producer.stream;

import com.demo.Producer.producer.WikiMediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikiMediaProducer Producer;


    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikiMediaProducer producer) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        Producer = producer;
    }


    public void consumeStreamAndPublish(){
        webClient
                .get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(Producer::sendMessage);
    }
}
