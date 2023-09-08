package vn.techmaster.course.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.course.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    //folder luu tru file

    private static String uploadDir = System.getProperty("user.dir")
            .concat(File.separator)
            .concat("uploads");

    public FileServiceImpl() {
        createFolder(uploadDir);
    }


    private void createFolder(String filePath) {
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }
    }


    @Override
    public String uploadFile(MultipartFile file) {
        String fileId = UUID.randomUUID().toString();
        File fileSever = new File(uploadDir.concat(File.separator).concat(fileId));
        try {
            file.transferTo(fileSever);
            return "/api/v1/files/".concat(fileId);
        }catch(IOException e) {
            throw new RuntimeException("Loi upload FILE!");
        }
    }

    @Override
    public byte[] readFile(String id) {
        File fileSever = new File(uploadDir.concat(File.separator).concat(id));
        if(!fileSever.exists()) {
            throw new RuntimeException("File ko ton tai");
        }
        try {
            return Files.readAllBytes(fileSever.toPath());
        }catch(IOException e) {
            throw new RuntimeException("Loi doc file");
        }
    }
}
