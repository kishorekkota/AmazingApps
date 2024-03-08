package com.example.sse_api;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController("/sse")
@ComponentScan
public class RestAPIWithSSE {


    @GetMapping(value ="/test", produces = "text/event-stream")
    public Flux serverSideEvent(){

        int count=0;
        while(true)
        {
            try {
                Thread.sleep(1000);
                Flux.just("Hello", "World");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello");
            count++;
            if(count > 5)
                break;
        }


        return Flux.just("Hello", "World");
    }

}
