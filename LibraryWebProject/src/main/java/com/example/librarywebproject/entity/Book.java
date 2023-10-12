package com.example.librarywebproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String description;
    private String thumbnail;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "published_at")
    private Date publishedAt;

    private String ISBN;
    private String slug;
    @Column(name = "copies_available")
    private int copiesAvailable;

    @Temporal(TemporalType.DATE)
    @Column(name = "publication_year")
    private Date publicationYear;

    @ManyToOne
    @JoinColumn(name = "publish_company_id")
    private PublishCompany publishCompany;

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "Book_Category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany(mappedBy = "books")
    private List<BorrowManagement> borrowManagements;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
