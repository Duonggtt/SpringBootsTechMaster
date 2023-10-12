package com.example.librarywebproject.model.dto;


import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReaderDto {
    private Integer id;
    private String fullName;
    private String address;
    private Date birth;
    private String avatar;
    private String email;
    private String phone;
}
