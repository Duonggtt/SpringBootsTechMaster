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
@Table(name = "borrowManagement")
public class BorrowManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_at")
    private Date borrowAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_at")
    private Date dueAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_at")
    private Date returnAt;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    @ManyToMany
    @JoinTable(
            name = "BorrowManagement_Book",
            joinColumns = @JoinColumn(name = "borrow_management_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    @ManyToMany
    @JoinTable(
            name = "BorrowManagement_Reader",
            joinColumns = @JoinColumn(name = "borrow_management_id"),
            inverseJoinColumns = @JoinColumn(name = "reader_id")
    )
    private List<Reader> readers;

    @OneToOne(mappedBy = "borrowManagement")
    private Cart cart;

    @OneToOne(mappedBy = "borrowManagement")
    private LateReturnFines lateReturnFines;
}
