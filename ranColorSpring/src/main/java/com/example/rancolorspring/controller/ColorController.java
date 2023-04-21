package com.example.rancolorspring.controller;

import com.example.rancolorspring.model.Color;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class ColorController {

    @PostMapping("/random-color")
    public ResponseEntity<?> postAPI(@RequestParam(value = "type") int type ) {
        String color = "";

        switch (type) {
            case 1:
                color = getRandomHexColor();
                break;
            case 2:
                color = getRandomColor();
                break;
            case 3:
                color = getRandomRgbColor();
                break;
        }
        return ResponseEntity.ok(color);
    }
    private static Random random = new Random();

    private String getRandomRgbColor() {
        String color = "rgb(";
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        color += (r + ", " + g + ", " + b + ")");
        return color;
    }

    private String getRandomColor() {
        List<String> color = new ArrayList<>();
        String res = "";
        color.add("red");
        color.add("blue");
        color.add("green");
        color.add("purple");

        res += color.get((int) Math.floor(Math.random() * color.size()));
        return res;
    }

    public String getRandomHexColor() {
        String hex = "123456789abcdef";
        String color = "#";
        for(int i = 0 ; i< 6 ; i++) {
            color += hex.charAt((int) Math.floor(Math.random() * hex.length()));
        }
        return color;
    }


}
