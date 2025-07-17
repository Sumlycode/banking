package com.example.banking.service.user;

import com.example.banking.entities.User;
import com.example.banking.model.req.UserCreateReq;
import com.example.banking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private static final Random random = new Random();

    @Override
    public String createUser(UserCreateReq req) {
        User user = new User();
        user.setUserName(req.getUserName());
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setPassword(req.getPassword());
        user.setIdCard(String.valueOf(100_000_000 + random.nextInt(900_000_000)));
        user.setAmount(500.0);
        userRepository.save(user);
        return "Created User Success!";
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
