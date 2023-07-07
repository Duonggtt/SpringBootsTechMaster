package com.example.springrelation.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "file_server")
public class FileServer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="type")
    private String type;

    @Lob
    @Column(name="data", columnDefinition = "LONGBLOB")
    private byte[] data;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}