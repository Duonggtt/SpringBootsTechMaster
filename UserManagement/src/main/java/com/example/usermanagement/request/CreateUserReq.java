package com.example.usermanagement.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserReq {
    private String name;
    private String email;
    private String password;
    private String phone;
}
