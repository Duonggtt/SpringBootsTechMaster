package com.example.bmicaculator.controller;

import com.example.bmicaculator.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/bmi")
    public ResponseEntity<?> getBmi(@RequestParam double height, @RequestParam double weight) throws Exception {
        if(weight <=0 || height <= 0) {
            throw new Exception("Invalid height and weight!");
        }
        double bmi = weight / (weight * height);
        return ResponseEntity.ok(bmi);
    }

    @PostMapping("/bmi")
    public ResponseEntity<?> postApi(@RequestBody User user) throws Exception {
        double height = user.getHeight();
        double weight = user.getWeight();

        if(height <= 0 || weight <= 0) {
            throw new Exception("Invalid height and weight!");
        }
        double bmi = weight / (weight * height);

        return ResponseEntity.ok(bmi);
    }
}
