package com.example.usermanagement.model.entity;

import lombok.Data;

@Data
public class UserDto {
    private int id;

    private String name;

    private String email;

    private String phone;

    private String avatar;
}
