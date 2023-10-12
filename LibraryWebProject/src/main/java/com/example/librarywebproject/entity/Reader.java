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
@Table(name = "reader")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birth;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "reader")
    private Card card;

    @OneToMany(mappedBy = "reader")
    private List<Comment> comments;

    @ManyToMany(mappedBy = "readers")
    private List<BorrowManagement> borrowManagements;
}
