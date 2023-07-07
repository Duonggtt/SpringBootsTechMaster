package com.example.springrelation.controller;

import com.example.springrelation.entity.FileServer;
import com.example.springrelation.service.FileServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/files")
public class FileServerController {

    @Autowired
    private FileServerService fileServerService;

    //xem file
    @GetMapping("{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id){
        FileServer fileServer = fileServerService.getFileById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileServer.getType()))
                .body(fileServer.getData());
    }

    //xoa file
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id){
        fileServerService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }
}
