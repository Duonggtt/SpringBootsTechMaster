package vn.techmaster.course.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadFile(MultipartFile file);

    byte[] readFile(String id);
}
