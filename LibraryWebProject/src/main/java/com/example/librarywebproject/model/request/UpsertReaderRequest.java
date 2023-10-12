package com.example.librarywebproject.model.request;

import com.example.librarywebproject.entity.BorrowManagement;
import com.example.librarywebproject.entity.Card;
import com.example.librarywebproject.entity.Comment;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertReaderRequest {
    private String  fullName;
    private String address;
    private Date birth;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private String phone;

}
