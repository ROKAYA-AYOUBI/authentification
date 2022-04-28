package com.example.authentificationapi.security.services;

import com.example.authentificationapi.models.User;
import com.example.authentificationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }
}
