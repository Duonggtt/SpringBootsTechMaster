package com.example.b3prj;

import org.springframework.stereotype.Component;

@Component
public class User {
    public User() {
        System.out.println("User created");
    }

    public void work() {
        System.out.println("User work");
    }
}
