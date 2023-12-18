package com.example.demosecucustomuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String getHome() {
        return "Home Page";
    }

    @GetMapping("/profile")
    public String getProfile() {
        return "Profile Name";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Admin Page";
    }

}
