package com.example.blogappdemo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    private String avatar;
    private String password;

    @ManyToMany(mappedBy = "userList")
    private List<Role> roleList;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogList;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

    @OneToMany(mappedBy = "user")
    private List<Image> imageList;
}
