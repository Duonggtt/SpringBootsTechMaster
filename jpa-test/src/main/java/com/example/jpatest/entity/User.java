package com.example.jpatest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone", length = 10)
    private String phone;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "role", nullable = false, columnDefinition = "varchar(250) default 'USER'")
    private String role;

}
