package com.example.sse_api;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;

@RestController
@ComponentScan
public class RestAPIWithSSE {

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping(value ="/test", produces = "text/event-stream")
    public Flux<ServerSentEvent<String>> serverSideEvent(){

        System.out.println("Event Stream called");

        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<String>builder()
                        .id(String.valueOf(sequence))
                        .event("update")
                        .data("Server time: " + LocalTime.now())
                        .build());
    }

}
