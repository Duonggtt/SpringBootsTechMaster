package com.example.springrelation.controller;

import com.example.springrelation.entity.FileServer;
import com.example.springrelation.entity.User;
import com.example.springrelation.service.FileServerService;
import com.example.springrelation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileServerService fileServerService;

    @GetMapping("")
    public ResponseEntity<?> getUsers() {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("{id}/files")
    public ResponseEntity<?> getFiles(@PathVariable Integer id) {
        List<FileServer> fileServerList= fileServerService.getFilesOfUser(id);
        return ResponseEntity.ok(fileServerList);
    }

    //upload file
    @PostMapping("{id}/files")
    public ResponseEntity<?> uploadFile(@ModelAttribute("file") MultipartFile file, @PathVariable Integer id) {
        return ResponseEntity.ok(fileServerService.uploadFile(id,file));
    }

}
