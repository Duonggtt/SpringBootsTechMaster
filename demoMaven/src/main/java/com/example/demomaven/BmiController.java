package com.example.demomaven;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BmiController {
    @GetMapping("/bmi")
    public ResponseEntity<?> getBMI(@RequestParam("height") String height, @RequestParam("weight") String weight) {
        //Thêm logic để kiểm tra xem param truyền vào có hợp lệ hay ko
        //Tính BMI từ 2 param đó
        //CT: BMI = weight / height * height
        return ResponseEntity.ok("");
    }
    @PostMapping("/bmi")
    public ResponseEntity<?> postBMI(@RequestBody BMIRequest bmiRequest) {

        //tính toán BMI dựa trên BMIRequest
        return ResponseEntity.ok(bmiRequest);
    }
}
