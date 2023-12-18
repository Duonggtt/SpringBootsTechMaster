package com.example.libexpress.model.request;

import com.example.libexpress.entity.BorrowManagementDetail;
import com.example.libexpress.entity.Librarian;
import com.example.libexpress.entity.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertBorrowRequest {
    private Integer userId;
    private String username;
    private Date borrowDate;
    private int borrowDateQuantity;
    private int book_quantity;
    private String status;
    private Integer librarianId;
}
