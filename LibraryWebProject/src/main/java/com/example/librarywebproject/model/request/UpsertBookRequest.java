package com.example.librarywebproject.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertBookRequest {
    private String title;
    private String content;
    private String description;
    private String thumbnail;

    private Date createdAt;
    private Date updatedAt;
    private Date publishedAt;

    private String ISBN;
    private String slug;
    private int copiesAvailable;
    private Date publicationYear;
    private List<Integer> categoryIds; // Danh sách id của các category áp dụng
}
