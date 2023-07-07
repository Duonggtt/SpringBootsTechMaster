package com.example.usermanag2.controller;

import com.example.usermanag2.dto.CreateUserRequest;
import com.example.usermanag2.dto.UpdateUserPasswordRequest;
import com.example.usermanag2.dto.UpdateUserRequest;
import com.example.usermanag2.dto.UserDTO;
import com.example.usermanag2.repository.UserRepositoty;
import com.example.usermanag2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("");
    }

    @PostMapping("")
    public UserDTO createUser(@Valid @RequestBody CreateUserRequest rq) {
        return userService.createUser(rq);
    }
}
