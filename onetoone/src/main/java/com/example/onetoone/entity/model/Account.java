package com.example.onetoone.entity.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String accountNumber;
    private double balance;
}
