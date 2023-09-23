package com.example.blogappdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @ManyToMany(mappedBy = "categoryList")
    private List<Blog> blogList;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
