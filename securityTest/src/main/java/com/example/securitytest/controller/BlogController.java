package com.example.securitytest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authority/blogs")
public class BlogController {
    @GetMapping("/")
    public String getAllBlogs() {
        return null;
    }

    @PostMapping("/create")
    public String createBlog() {
        return null;
    }

    @PutMapping("/update/{id}")
    public String updateBlog(@PathVariable Integer id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id) {
        return null;
    }

}
