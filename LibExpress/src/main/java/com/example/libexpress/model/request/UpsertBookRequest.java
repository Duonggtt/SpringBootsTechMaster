package com.example.libexpress.model.request;

import com.example.libexpress.entity.Author;
import com.example.libexpress.entity.Publisher;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertBookRequest {
    private String title;
    private Integer authorId;
    private Integer publisherId;
    private int publishYear;
    private int quantity;
    private String summaryContent;
    private int price;
    private String thumbnail;
    private List<Integer> categoryIds; // Danh sách id của các category áp dụng

}
