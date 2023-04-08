package com.example.usermanagement.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserReq {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String avatar;
}
