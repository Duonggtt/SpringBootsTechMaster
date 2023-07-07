package com.example.blogprj.controller;

import com.example.blogprj.model.CategoryDto;
import com.example.blogprj.repository.CategoryDtoRepository;
import com.example.blogprj.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryDtoRepository categoryDtoRepository;

    public List<CategoryDto> getCategories() {
        List<CategoryDto> categoryDtos = categoryDtoRepository.findAll();
        return categoryDtos;
    }

}
