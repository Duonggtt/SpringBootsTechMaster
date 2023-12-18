package com.example.libexpress.rest;

import com.example.libexpress.entity.Category;
import com.example.libexpress.entity.Publisher;
import com.example.libexpress.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/publishers")
public class PublisherResource {

    private final PublisherService publisherService;

    public PublisherResource(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPublishers(@RequestParam(required = false, defaultValue = "id") String sortField,
                                              @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                              @RequestParam(required = false, defaultValue = "1") Integer page,
                                              @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(publisherService.getAllPublishers(page, limit , sortField, sortDirection));
    }


    @PostMapping
    public ResponseEntity<?> createPublisher(@Valid @RequestBody Publisher request) {
        return new ResponseEntity<>(publisherService.createPublisher(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePublisher(@PathVariable Integer id,@Valid @RequestBody Publisher request) {
        return new ResponseEntity<>(publisherService.updatePublisher(id,request), HttpStatus.CREATED);
    }

    //    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(@Valid @RequestBody UpsertBlogRequest request, @PathVariable Integer id) {
//        return ResponseEntity.ok(blogService.updateBlog(id, request));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPublisherById(@PathVariable Integer id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }


}
