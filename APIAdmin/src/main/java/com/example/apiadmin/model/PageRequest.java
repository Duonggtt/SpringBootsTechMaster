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
    private int totalPages  = 2 ;
    private int totalItems = 19;
    private List<Course> courseList;
}
