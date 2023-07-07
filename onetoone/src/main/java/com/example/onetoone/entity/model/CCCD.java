package com.example.onetoone.entity.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CCCD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String number;
}
