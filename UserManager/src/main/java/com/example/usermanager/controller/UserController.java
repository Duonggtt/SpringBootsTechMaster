package com.example.usermanager.controller;

import com.example.usermanager.model.User;
import com.example.usermanager.model.UserDto;
import com.example.usermanager.request.CreateUserReq;
import com.example.usermanager.request.UpdateUserReq;
import com.example.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getUserApi() {
        return ResponseEntity.ok(userService.getUserDTO());
    }

    @GetMapping("/users/search")
    public ResponseEntity<?> getUserByName(@RequestParam String name) {
        UserDto user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@RequestBody CreateUserReq user) {
        UserDto newUser = userService.createUserReq(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserReq req, @PathVariable int id) {
        UserDto user = userService.updateUser(req,id);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser( @PathVariable int id) {
        boolean user = userService.removeUser(id);
        return ResponseEntity.ok(user);
    }
}
