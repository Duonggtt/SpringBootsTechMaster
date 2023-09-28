package com.example.testsb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="post")
public class Post {
    @Id
    private String id;
    private String title;


    //goi truoc khi luu vao CSDL
    @PrePersist
    private void generateId() {
        if (id == null) {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder randomString = new StringBuilder();

            Random random = new Random();
            for (int i = 0; i < 4; i++) {
                int index = random.nextInt(chars.length());
                char randomChar = chars.charAt(index);
                randomString.append(randomChar);
            }
            id = randomString.toString();


            //hoac don gian hon la su dung UUID
            // Tạo một UUID ngẫu nhiên làm ID
            //id = UUID.randomUUID().toString();
        }
    }
}
