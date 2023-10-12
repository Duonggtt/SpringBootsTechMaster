package com.example.librarywebproject.controller;

import com.example.librarywebproject.entity.Reader;
import com.example.librarywebproject.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/readers")
public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllReader() {
        List<Reader> readerList = readerRepository.findAll();
        return ResponseEntity.ok(readerList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateReader(@PathVariable Integer id) {
        return null;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createReader() {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReader(@PathVariable Integer id) {
        return null;
    }



}
