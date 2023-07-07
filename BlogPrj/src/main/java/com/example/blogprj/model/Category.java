package com.example.blogprj.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name="name" , nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Blog> blogs = new ArrayList<>();

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
