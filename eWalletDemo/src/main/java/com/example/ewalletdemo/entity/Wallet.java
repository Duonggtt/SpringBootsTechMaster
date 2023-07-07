package com.example.ewalletdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name= "balance")
    private int balance;
    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
