package com.example.libexpress.entity;

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
@Table(name = "borrow_management_detail")
public class BorrowManagementDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_author")
    private String bookAuthor;


    @Column(name = "book_status")
    private String bookStatus;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "borrow_management_id")
    private BorrowManagement borrowManagement;

    @OneToOne
    @JoinColumn(name = "fines_id")
    private Fines fines;
}
