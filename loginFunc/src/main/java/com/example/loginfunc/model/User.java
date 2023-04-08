package com.example.loginfunc.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String avatar;

    public User(int id, String username, String email, String password, String avatar) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
    }
}
