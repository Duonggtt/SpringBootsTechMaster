package com.example.usermanagement.controller;

import com.example.usermanagement.model.entity.UserDto;
import com.example.usermanagement.request.CreateUserReq;
import com.example.usermanagement.request.UpdateUserReq;
import com.example.usermanagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

    @GetMapping("userdto")
    public ResponseEntity<?> getListUserDTO() {
        return ResponseEntity.ok(userService.getUserDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable @Min(value = 3, message = "user id must ... ") int id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @PostMapping("")
    public ResponseEntity<?> createUserReq( @Valid @RequestBody CreateUserReq req) {
        UserDto result = userService.createUserReq(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserReq req, int id) {
        UserDto result = userService.updateUser(req,id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeUser(@PathVariable int id) {
        userService.removeUser(id);
        return ResponseEntity.ok("Delete success");
    }


        
}
