package com.example.bths2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bths2.entity.User;
import com.example.bths2.repository.UserRepository;
import com.example.bths2.util.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String authenticate(String username, String password) {
        User user = userRepository.findByUserName(username);
        if (user != null && user.getPassword().equals(password)) { // Nên dùng mã hóa MD5 hoặc BCrypt
            String token = JwtUtil.generateToken(username);
            user.setToken(token);
            userRepository.save(user);
            return token;
        }
        return null;
    }
}
