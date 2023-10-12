package com.example.librarywebproject.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;
}
