package com.example.securitytest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/categories")
public class CategoryController {

    @GetMapping("/")
    public String getAllCategory() {
        return null;
    }

    @PostMapping("/create")
    public String createCategory() {
        return null;
    }

    @PutMapping("/update/{id}")
    public String updateCategory(@PathVariable Integer id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        return null;
    }


}
