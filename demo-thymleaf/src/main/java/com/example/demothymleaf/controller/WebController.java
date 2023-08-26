package com.example.demothymleaf.controller;

import com.example.demothymleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    List<User> users;

    public WebController() {
        users = new ArrayList<>();
        users.add(new User(1,"Tran Van A","a@gmail.com"));
        users.add(new User(2,"Tran Van B","b@gmail.com"));
        users.add(new User(3,"Tran Van C","c@gmail.com"));
    }

    @GetMapping("/")
    public String getHome(Model model) {
        String name = "Duong";
        model.addAttribute("name",name);
        model.addAttribute("user",users.get(0));
        model.addAttribute("userList",users);
        model.addAttribute("age", 18);
        model.addAttribute("day",4);
        model.addAttribute("isAdmin",true);
        return "index";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin/admin";
    }
}
