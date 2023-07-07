package com.example.usermanag2.service;

import com.example.usermanag2.dto.CreateUserRequest;
import com.example.usermanag2.dto.UpdateUserPasswordRequest;
import com.example.usermanag2.dto.UpdateUserRequest;
import com.example.usermanag2.dto.UserDTO;
import com.example.usermanag2.entity.User;
import com.example.usermanag2.exception.NotFoundException;
import com.example.usermanag2.mapper.UserMapper;
import com.example.usermanag2.model.FileResponse;
import com.example.usermanag2.repository.UserDB;
import com.example.usermanag2.repository.UserRepositoty;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepositoty userRepositoty;


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepositoty.getAllUsers();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User u: userList) {
            userDTOList.add(UserMapper.toUserDTO(u));
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> getUserByNameContain(String name) {
        return UserDB.users.stream().filter(u->u.getName().toLowerCase().contains(name.toLowerCase()))
                .map(user ->new UserDTO(user.getId(), user.getName(), user.getEmail() ,user.getPhone(), user.getAvatar())).toList();
    }

    @Override
    public UserDTO getUserById(Integer id) {
        Optional<User> user2Find = Optional.of(UserDB.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow());
        User user = user2Find.get();
        return new UserDTO(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.getAvatar());
    }

    @Override
    public UserDTO createUser(CreateUserRequest userRq) {
        for(User user : UserDB.users) {
            if(user.getEmail().equals(userRq.email())) {
                throw new DuplicateRequestException("Email da ton tai!");
            }
        }
        User user = new User();
        user.setName(userRq.name());
        user.setEmail(userRq.email());
        user.setPhone(userRq.phone());
        user.setAvatar(userRq.avatar());
        user.setPassword(userRq.password());
        userRepositoty.createUser(user);
        return new UserDTO(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.getAvatar());
    }

    @Override
    public UserDTO updateUser(int id, UpdateUserRequest userRq) {
        return null;
    }

    @Override
    public void deleteUser(int id) {
        boolean result = userRepositoty.deleteUser(id);
        if(!result) {
            throw new NotFoundException("Id not found");
        }
    }

    @Override
    public UserDTO updateUserPassword(int id, UpdateUserPasswordRequest userRq) {
        return null;
    }

    @Override
    public FileResponse updateUserAvatar(int id, MultipartFile file) {
        return null;
    }
}
