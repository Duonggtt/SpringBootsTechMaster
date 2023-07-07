package com.example.demothymleafsecurity.controller;

import com.example.demothymleafsecurity.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebController {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    //ai cung co the vao dc
    @GetMapping("/")
    public String getHome() {
        return "Home page";
    }

    //co role admin hoac author ms co the vao dc
    @GetMapping("/profile")
    public String getProfile() {
        return "Profile page";
    }

    //phai co role admin
    @GetMapping("/admin")
    public String getAdmin() {
        return "Admin page";
    }

    //phai co role author
    @GetMapping("/author")
    public String getAuthor() {
        return "Author page";
    }

    @GetMapping("/get-info")
    public UserDetails getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails;
        }
        return null;
    }

}
