package com.example.demofile.service;

import com.example.demofile.model.entity.FileServer;
import com.example.demofile.model.entity.User;
import com.example.demofile.repository.FileServerRepository;
import com.example.demofile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private final FileServerRepository fileServerRepository;

    @Autowired
    private final UserRepository userRepository;

    public FileService(FileServerRepository fileServerRepository, UserRepository userRepository) {
        this.fileServerRepository = fileServerRepository;
        this.userRepository = userRepository;
    }

    public FileServer uploadFile(Integer userId, MultipartFile file) throws IOException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));

        FileServer fileServer = new FileServer();
        fileServer.setType(file.getContentType());
        fileServer.setData(file.getBytes());
        fileServer.setUser(user);
        fileServerRepository.save(fileServer);

        return fileServer;
    }

    public FileServer getFileById(Integer id) {
        return fileServerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id " + id));
    }

    public void deleteFile(Integer id) {
        FileServer file = getFileById(id);
        fileServerRepository.delete(file);
    }

}
