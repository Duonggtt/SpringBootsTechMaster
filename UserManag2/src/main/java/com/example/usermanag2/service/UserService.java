package com.example.usermanag2.service;

import com.example.usermanag2.dto.CreateUserRequest;
import com.example.usermanag2.dto.UpdateUserPasswordRequest;
import com.example.usermanag2.dto.UpdateUserRequest;
import com.example.usermanag2.dto.UserDTO;
import com.example.usermanag2.model.FileResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    List<UserDTO> getUserByNameContain(String name);
    UserDTO getUserById(Integer id);
    UserDTO createUser(CreateUserRequest userRq);
    UserDTO updateUser(int id, UpdateUserRequest userRq);
    void deleteUser(int id);
    UserDTO updateUserPassword(int id, UpdateUserPasswordRequest userRq);
    FileResponse updateUserAvatar(int id, MultipartFile file);
}
