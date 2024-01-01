package com.example.libexpress.service;

import com.example.libexpress.entity.Author;
import com.example.libexpress.entity.Category;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.request.CreateUserRequest;
import com.example.libexpress.model.request.UpdateUserRequest;
import com.example.libexpress.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public Page<Category> getAllCategories(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return categoryRepository.findAll(pageRequest);
    }

    public Page<Category> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Category> categoryPage;
        if(keyword != null) {
            categoryPage = categoryRepository.findAll(keyword,pageable);
        }else {
            categoryPage = categoryRepository.findAll(pageable);
        }

        List<Category> authorList = categoryPage.getContent();

        return new PageImpl<>(authorList, pageable, categoryPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Category createCategory(Category request) {
        Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);
        return category;
    }

    public Category updateCategory(Integer id, Category request) {
        List<Category> categoryList = categoryRepository.findAll();
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy danh mục có id " + id));

        category.setName(request.getName());
        categoryRepository.save(category);
        return category;
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy danh mục có id " + id));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
