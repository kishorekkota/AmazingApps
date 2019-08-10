package com.example.springwiremock;


import com.example.springwiremock.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    AccountService service;

    @GetMapping("/hello")
    public String hello()
    {

        service.createAccount(null);


        return "Hello";
    }
}
