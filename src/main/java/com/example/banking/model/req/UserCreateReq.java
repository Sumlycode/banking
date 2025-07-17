package com.example.banking.model.req;

import lombok.Data;

@Data
public class UserCreateReq {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
