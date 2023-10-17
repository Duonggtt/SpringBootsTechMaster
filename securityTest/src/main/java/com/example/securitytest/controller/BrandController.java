package com.example.securitytest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/brands")
public class BrandController {
    @GetMapping("/")
    public String getAllBrands() {
        return null;
    }

    @PostMapping("/create")
    public String createBrand() {
        return null;
    }

    @PutMapping("/update/{id}")
    public String updateBrand(@PathVariable Integer id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable Integer id) {
        return null;
    }
}
