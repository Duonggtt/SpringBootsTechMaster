package com.example.securitytest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/orders")
public class OrderController {
    @GetMapping("/")
    public String getAllOrders() {
        return null;
    }

    @PostMapping("/create")
    public String createOrder() {
        return null;
    }

    @PutMapping("/update/{id}")
    public String updateOrder(@PathVariable Integer id) {
        return null;
    }


}
