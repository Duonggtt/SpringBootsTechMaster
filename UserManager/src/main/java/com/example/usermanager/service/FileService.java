package com.example.usermanager.service;

import com.example.usermanager.model.FileResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface FileService {
    FileResponse uploadFile(MultipartFile file);

    byte[] readFile(String id);
}
