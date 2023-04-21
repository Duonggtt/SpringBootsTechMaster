package com.example.apiadmin.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<T> {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private long totalItems;
    private List<T> data;
}
