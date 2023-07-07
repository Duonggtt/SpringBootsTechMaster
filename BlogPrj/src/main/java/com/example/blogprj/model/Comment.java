package com.example.blogprj.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name="update_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name="blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @PrePersist
    public void PrePersist() {
        createdAt = LocalDateTime.now();
        updateAt = createdAt;
    }

    @PreUpdate
    public void PreUpdate() {
        updateAt = LocalDateTime.now();
    }
}
