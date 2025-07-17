package com.example.banking.controller;

import com.example.banking.entities.User;
import com.example.banking.model.req.UserCreateReq;
import com.example.banking.service.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {
    private final IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody UserCreateReq req){
      return ResponseEntity.ok(userService.createUser(req));
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
}
