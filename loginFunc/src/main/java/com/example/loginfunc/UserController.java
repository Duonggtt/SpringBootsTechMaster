package com.example.loginfunc;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        if(username == "admin" && password == "123") {
            User AdminAccount = new
                    User(1, "admin", "admin@gmail.com", "123","avatar");

            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.badRequest().body("INCORECT INFORMATION!!!");
        }
    }
//
//    @GetMapping("/home")
//    public String login() {
//        return "index.html";
//    }
}
