package com.example.springwiremock.account;

import lombok.Data;

@Data
public class AccountDTO {

    private String name;
    private String email;
    private String username;



    public void verifyUsernameExists()
    {

    }


    public void accountLocked()
    {

    }

    public void activate()
    {

    }
}
