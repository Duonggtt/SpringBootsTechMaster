package com.example.libexpress.model.request;

import com.example.libexpress.entity.Book;
import com.example.libexpress.entity.Fines;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertBorrowDetailRequest {
    private Integer bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookStatus;
    private Integer finesId;
    private Integer borrowId;
}
