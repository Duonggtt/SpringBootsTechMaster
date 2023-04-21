package com.example.themeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControler {
    @RequestMapping("/home")
    public String hello() {
        return "hello";
    }
}
