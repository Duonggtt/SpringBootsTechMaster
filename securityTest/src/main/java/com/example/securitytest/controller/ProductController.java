package com.example.securitytest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/products")
public class ProductController {

    @GetMapping("/")
    public String getAllProducts() {
        return null;
    }

    @PostMapping("/create")
    public String createProduct() {
        return null;
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return null;
    }

}
