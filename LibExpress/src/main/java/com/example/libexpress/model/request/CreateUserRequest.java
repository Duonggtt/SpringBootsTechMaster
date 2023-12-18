package com.example.libexpress.model.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserRequest {
    private String fullName;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String phone;
    private String email;
    private boolean status;
    private boolean cardCreated;
}
