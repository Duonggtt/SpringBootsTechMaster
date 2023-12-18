package com.example.libexpress.rest;

import com.example.libexpress.repository.LibraryCardRepository;
import com.example.libexpress.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/users/create-card")
public class LibraryCardResource {

    private final UserService userService;
    private final LibraryCardRepository cardRepository;

    public LibraryCardResource(UserService userService, LibraryCardRepository cardRepository) {
        this.userService = userService;
        this.cardRepository = cardRepository;
    }

    @PostMapping
    public ResponseEntity<?> createCard(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.createCard(userId));
    }
}
