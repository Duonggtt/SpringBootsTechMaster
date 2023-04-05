package com.example.demomaven;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {
    @RequestMapping(value = "/random-color")
    public ResponseEntity<?> getRandomColor(@RequestParam("type") Integer type) {
        String randomColor = "";

        //add thêm logic để xử lý trả về random
        switch (type) {
            case 1:
                randomColor = "Green";
                break;
            case 2:
                randomColor = "#f44336";
                break;
            case 3:
                randomColor = "rgb(96, 125, 139)";
                break;
        }
        return ResponseEntity.ok(randomColor);
    }


}
