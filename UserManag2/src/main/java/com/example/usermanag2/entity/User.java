package com.example.usermanag2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true,setterPrefix = "width")
public class User {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String avatar;
    private String password;
}
