package com.example.bths2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bths2.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        String token = userService.authenticate(username, password);
        if (token != null) {
            return "Token: " + token; // Trả về token nếu đăng nhập thành công
        } else {
            return "Invalid credentials"; // Nếu thông tin đăng nhập không đúng
        }
    }
}
