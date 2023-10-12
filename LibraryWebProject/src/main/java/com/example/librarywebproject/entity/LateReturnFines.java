package com.example.librarywebproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "lateReturnFines")
public class LateReturnFines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reason;
    @Column(name = "punish_price")
    private float punishPrice;

    @Temporal(TemporalType.DATE)
    @Column(name = "punish_at")
    private Date punishAt;

    @OneToOne
    @JoinColumn(name = "borrow_management_id")
    private BorrowManagement borrowManagement;

}
