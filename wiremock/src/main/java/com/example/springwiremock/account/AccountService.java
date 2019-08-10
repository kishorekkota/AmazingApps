package com.example.springwiremock.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountService {

    @Autowired
    RestTemplate restTemplate;

    public void createAccount(AccountDTO account)
    {

        System.out.println(restTemplate.getForObject("http://localhost:8080/api/mytest-true",String.class));

    }
}
