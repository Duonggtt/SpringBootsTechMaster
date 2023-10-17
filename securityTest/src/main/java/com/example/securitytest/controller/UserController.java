package com.example.securitytest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return null;
    }

    @GetMapping("/admin/users")
    public String getAllUser() {
        return null;
    }

    @PostMapping("/admin/create")
    public String createUser() {
        return null;
    }

    @PutMapping("/admin/update/{id}")
    public String updateUser(@PathVariable Integer id) {
        return null;
    }

}
