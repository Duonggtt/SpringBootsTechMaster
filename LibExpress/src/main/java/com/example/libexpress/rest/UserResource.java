package com.example.libexpress.rest;

import com.example.libexpress.entity.User;
import com.example.libexpress.model.request.CreateUserRequest;
import com.example.libexpress.model.request.UpdateUserRequest;
import com.example.libexpress.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUser(@RequestParam(required = false, defaultValue = "id") String sortField,
                                        @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                         @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(userService.getAllUser(page, limit , sortField, sortDirection));
    }


    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,@Valid @RequestBody UpdateUserRequest request) {
        return new ResponseEntity<>(userService.updateUser(id,request), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(@Valid @RequestBody UpsertBlogRequest request, @PathVariable Integer id) {
//        return ResponseEntity.ok(blogService.updateBlog(id, request));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
