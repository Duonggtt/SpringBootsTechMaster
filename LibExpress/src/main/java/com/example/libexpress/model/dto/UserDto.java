package com.example.libexpress.model.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private Integer id;
    private String fullName;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private String address;
    private String phone;
    private String email;
    private boolean status;
    private boolean cardCreated;
    private String avatar;
}
