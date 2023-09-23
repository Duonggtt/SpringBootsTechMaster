package com.example.demofile.controller;


import com.example.demofile.model.entity.FileServer;
import com.example.demofile.model.entity.User;
import com.example.demofile.repository.FileServerRepository;
import com.example.demofile.repository.UserRepository;
import com.example.demofile.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    private final FileServerRepository fileServerRepository;
    private final FileService fileService;
    private final UserRepository userRepository;

    public UserController(FileServerRepository fileServerRepository, FileService fileService,
                          UserRepository userRepository) {
        this.fileServerRepository = fileServerRepository;
        this.fileService = fileService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getUserPage(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/users/{id}/files")
    public String getFilesPage(Model model, @PathVariable Integer id) {
        List<FileServer> fileServerList = fileServerRepository.findByUser_IdOrderByCreatedAtDesc(id);
        model.addAttribute("files", fileServerList);
        model.addAttribute("userId",id);
        return "file";
    }

    @PostMapping("/api/users/{id}/files")
    public ResponseEntity<?> uploadFile(@PathVariable Integer id, @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.uploadFile(id, file));
    }
}
