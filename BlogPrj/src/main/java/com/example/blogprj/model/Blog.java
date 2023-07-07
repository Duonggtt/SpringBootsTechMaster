package com.example.blogprj.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="slug",nullable = false)
    private String slug;

    @Column(name="description",nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name="content",nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name="thumbnail")
    private String thumbnail;

    @Column(name="created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name="published_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime publishedAt;

    @Column(name="update_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateAt;

    @Column(name="status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "blog_category", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    public void PrePersist() {
        createdAt = LocalDateTime.now();
        updateAt = createdAt;
        if(status) {
            publishedAt = createdAt;
        }
    }

    @PreUpdate
    public void PreUpdate() {
        updateAt = LocalDateTime.now();
        if(status) {
            publishedAt = updateAt;
        }
    }
}
