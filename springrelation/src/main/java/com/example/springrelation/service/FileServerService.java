package com.example.springrelation.service;

import com.example.springrelation.entity.FileServer;
import com.example.springrelation.entity.User;
import com.example.springrelation.repository.FileServerRepository;
import com.example.springrelation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileServerService {

    @Autowired
    private FileServerRepository fileServerRepository;

    @Autowired
    private UserRepository userRepository;
    public List<FileServer> getFilesOfUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("NOT FOUND FILE!");
                });
        return fileServerRepository.findByUser_id(id);
    }

    public FileServer getFileById(Integer id) {
        return fileServerRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("NOT FOUND FILE!");
                });
    }

    public void deleteFile(Integer id) {
        FileServer fileServer = fileServerRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("NOT FOUND FILE!");
                });
        fileServerRepository.delete(fileServer);
    }

    public String uploadFile(Integer userId, MultipartFile file) {
        validateFile(file);

        //upload file
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new RuntimeException("NOT FOUND FILE!");
                });

        try{
            FileServer fileServer = FileServer.builder()
                    .type(file.getContentType())
                    .data(file.getBytes())
                    .user(user)
                    .build();

            fileServerRepository.save(fileServer);

            return "/api/v1/files/" + fileServer.getId();

        }catch(IOException e) {
            throw new RuntimeException("LOI KHI UPLOAD FILE!");
        }
    }

    public  void validateFile(MultipartFile file) {
        //validate file
        //-ten file
        //-dinh dang file co cho phep hay ko?
        //-kich thuoc file?

    }
}
