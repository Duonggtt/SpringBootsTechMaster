package com.example.jpa2techmaster.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone", length = 11)
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "role", nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String role;
}
