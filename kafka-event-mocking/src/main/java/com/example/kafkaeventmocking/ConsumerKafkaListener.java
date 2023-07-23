package com.example.kafkaeventmocking;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@ComponentScan
@Service
public class ConsumerKafkaListener {


    @KafkaListener(topics="quickstart-events",groupId = "test")
    public void listener(String message)
    {

        System.out.println(message);

    }

}
