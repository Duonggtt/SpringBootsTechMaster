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

    @OneToOne
    @JoinColumn(name = "borrow_management_id")
    private BorrowManagement borrowManagement;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "librarian_id")
    private Integer librarianId;

    private int amount;
    @Column(name = "borrow_date")
    private Date borrowDate;

    @Column(name = "borrow_date_quantity")
    private int borrowDateQuantity;

    @Column(name = "book_quantity")
    private int bookQuantity;
}
