package com.example.usermanager.service;

import com.example.usermanager.model.User;
import com.example.usermanager.model.UserDto;
import com.example.usermanager.request.CreateUserReq;
import com.example.usermanager.request.UpdateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUserList();

    List<UserDto> getUserDTO();

    UserDto getUserById(int id);
    UserDto getUserByName(String name);

    UserDto createUserReq(CreateUserReq createUserReq);

    UserDto updateUser(UpdateUserReq updateUserReq, int id);

    boolean removeUser(int id);
    User changePassword( UpdateUserReq updateUserReq, int id);
    User forgotPassword(UpdateUserReq updateUserReq,int id);
}
