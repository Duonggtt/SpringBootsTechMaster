package com.example.demomaven;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    // Xử lý request có đường dẫn "/login" với mọi HTTP method
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("Login");
    }
}
