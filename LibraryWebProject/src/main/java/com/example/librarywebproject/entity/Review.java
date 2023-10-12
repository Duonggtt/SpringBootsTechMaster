package com.example.librarywebproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reviewerName;
    private float rating;
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
