package com.example.libexpress.rest;

import com.example.libexpress.entity.Category;
import com.example.libexpress.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/categories")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false, defaultValue = "id") String sortField,
                                        @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(categoryService.getAllCategories(page, limit , sortField, sortDirection));
    }


    @PostMapping
    public ResponseEntity<?> createCategory(@Valid @RequestBody Category request) {
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id,@Valid @RequestBody Category request) {
        return new ResponseEntity<>(categoryService.updateCategory(id,request), HttpStatus.CREATED);
    }

    //    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(@Valid @RequestBody UpsertBlogRequest request, @PathVariable Integer id) {
//        return ResponseEntity.ok(blogService.updateBlog(id, request));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }


}
