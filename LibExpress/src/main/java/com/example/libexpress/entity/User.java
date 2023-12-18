package com.example.libexpress.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    private String address;
    private String phone;
    private String email;
    private boolean status;

    @Column(name = "card_created")
    private boolean cardCreated;
    private String avatar;

    @PrePersist
    public void getFullName() {
        fullName = "";
        if (firstName != null && lastName != null) {
            fullName += firstName + lastName;
        }
    }


}
