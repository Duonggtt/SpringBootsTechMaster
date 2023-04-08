package com.example.loginfunc.controller;

import com.example.loginfunc.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    User user = new User(1, "admin", "admin@gmail.com", "123","avatar");
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userLoged) {

        if(user.getUsername().equals(userLoged.getUsername()) && user.getPassword().equals(userLoged.getPassword())) {

            return ResponseEntity.ok().body(user);
        }else {
            return ResponseEntity.badRequest().body("INCORECT INFORMATION!!!");
        }
    }


}
