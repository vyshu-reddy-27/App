package com.example.App.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.App.Entity.User;
import com.example.App.Repository.UserRepository;

import jakarta.jws.soap.SOAPBinding.Use;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Use registerUser(Use user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAll(user);
    }

    public com.example.App.Entity.User findByUsername(String username) {
        return (User) UserRepository.findByUsername(username);
    }
}
