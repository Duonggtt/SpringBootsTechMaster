package com.example.demojpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private Integer age;
}
