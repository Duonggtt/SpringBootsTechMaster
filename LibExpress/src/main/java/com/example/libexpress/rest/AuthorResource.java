package com.example.libexpress.rest;

import com.example.libexpress.entity.Author;
import com.example.libexpress.entity.Category;
import com.example.libexpress.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/authors")
public class AuthorResource {


    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUser(@RequestParam(required = false, defaultValue = "id") String sortField,
                                        @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(authorService.getAllAuthors(page, limit , sortField, sortDirection));
    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@Valid @RequestBody Author request) {
        return new ResponseEntity<>(authorService.createAuthor(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id,@Valid @RequestBody Author request) {
        return new ResponseEntity<>(authorService.updateAuthor(id,request), HttpStatus.CREATED);
    }

    //    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(@Valid @RequestBody UpsertBlogRequest request, @PathVariable Integer id) {
//        return ResponseEntity.ok(blogService.updateBlog(id, request));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

}
