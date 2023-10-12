package com.example.quanlythuvien.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fullname")
    private String fullName;
    private String birth;
    private String phone;
    @Column(name = "id_num")
    private String idNum;
    private String address;
    private String password;

}
