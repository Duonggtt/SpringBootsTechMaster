package com.example.apiadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    private int currentPage = 1;
    private int pageSize = 10;
    private int totalPages;
    private int totalItems;
    private List<Course> courseList;
}
