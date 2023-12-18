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
@Table(name = "borrow_management")
public class BorrowManagement {
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

}
