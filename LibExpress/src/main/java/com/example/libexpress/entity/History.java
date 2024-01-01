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
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="user_name")
    private String username;

    @Column(name = "borrow_date")
    private Date borrowDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "borrow_date_quantity")
    private int borrowDateQuantity;

    @Column(name = "book_quantity")
    private int bookQuantity;
    private String status;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

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
