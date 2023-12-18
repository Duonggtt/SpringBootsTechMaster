package com.example.libexpress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private List<Book> books = new ArrayList<>();

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
