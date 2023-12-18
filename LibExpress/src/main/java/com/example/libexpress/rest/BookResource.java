package com.example.libexpress.rest;

import com.example.libexpress.model.request.CreateUserRequest;
import com.example.libexpress.model.request.UpdateUserRequest;
import com.example.libexpress.model.request.UpsertBookRequest;
import com.example.libexpress.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllBooks(@RequestParam(required = false, defaultValue = "id") String sortField,
                                        @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(bookService.getAllBooks(page, limit , sortField, sortDirection));
    }


    @PostMapping
    public ResponseEntity<?> creatBook(@Valid @RequestBody UpsertBookRequest request) {
        return new ResponseEntity<>(bookService.createBook(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Integer id,@Valid @RequestBody UpsertBookRequest request) {
        return new ResponseEntity<>(bookService.updateBook(id,request), HttpStatus.CREATED);
    }

    //    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(@Valid @RequestBody UpsertBlogRequest request, @PathVariable Integer id) {
//        return ResponseEntity.ok(blogService.updateBlog(id, request));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}

