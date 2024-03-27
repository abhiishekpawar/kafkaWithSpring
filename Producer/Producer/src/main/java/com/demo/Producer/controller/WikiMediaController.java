package com.demo.Producer.controller;

import com.demo.Producer.stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
@Slf4j
public class WikiMediaController {

    @Autowired
    private final WikimediaStreamConsumer streamConsumer;
    @GetMapping("/getStreams")
    public void startPublishing(){
        log.info("*********Started publishing to the topic**********");
        streamConsumer.consumeStreamAndPublish();

    }

}
