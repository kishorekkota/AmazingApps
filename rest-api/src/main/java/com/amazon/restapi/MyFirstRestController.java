package com.amazon.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstRestController
{

    @GetMapping("/gethello")
    public String getHello()
    {
        return "you got hello back";
    }

    @PostMapping("/testpost")
    public Ouput testendpoint(@RequestBody Input input)
    {

        Ouput test = new Ouput();

        return test;
    }


}
