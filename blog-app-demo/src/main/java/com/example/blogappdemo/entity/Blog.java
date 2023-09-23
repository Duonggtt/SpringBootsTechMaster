package com.example.blogappdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "blog")
@Builder
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String slug;
    private String description;
    private String content;
    private String thumbnail;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "published_at")
    private LocalDateTime publishedAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "blogList")
    private List<Category> categoryList;

    @OneToMany(mappedBy = "blog")
    private List<Comment> commentList;


    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        publishedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

}
