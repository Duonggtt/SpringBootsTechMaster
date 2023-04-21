package com.example.usermanagement.service;

import com.example.usermanagement.model.entity.User;
import com.example.usermanagement.model.entity.UserDto;
import com.example.usermanagement.request.CreateUserReq;
import com.example.usermanagement.request.UpdateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUser();

    List<UserDto> getUserDTO();

    UserDto getUserById(int id);

    UserDto getUserByName(String name);

    UserDto createUserReq(CreateUserReq createUserReq);

    UserDto updateUser(UpdateUserReq updateUserReq, int id);

    boolean removeUser(int id);
}

