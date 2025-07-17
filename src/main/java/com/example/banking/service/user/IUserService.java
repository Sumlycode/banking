package com.example.banking.service.user;

import com.example.banking.entities.User;
import com.example.banking.model.req.UserCreateReq;

import java.util.List;

public interface IUserService {
    String createUser(UserCreateReq req);
    List<User> getAllUser();
}
