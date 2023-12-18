package com.example.libexpress.entity;

import com.example.libexpress.repository.LibraryCardRepository;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "library_card")
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_card_seq")
    @SequenceGenerator(name = "library_card_seq", sequenceName = "library_card_seq", initialValue = 10000000, allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_birth_date")
    private Date userBirthDate;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "end_at")
    private Date end_at;

    private String avatar;

}
