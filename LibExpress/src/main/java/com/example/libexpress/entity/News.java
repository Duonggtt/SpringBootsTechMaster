package com.example.libexpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "published_at")
    private Date publishedAt;

    private String thumbnail;

    @Column(name = "information_at")
    private String informationAt;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;
}
