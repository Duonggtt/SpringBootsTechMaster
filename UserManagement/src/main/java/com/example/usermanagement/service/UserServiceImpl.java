package com.example.usermanagement.service;

import com.example.usermanagement.exception.NotFoundException;
import com.example.usermanagement.model.entity.User;
import com.example.usermanagement.model.entity.UserDto;
import com.example.usermanagement.model.mapper.UserMapper;
import com.example.usermanagement.request.CreateUserReq;
import com.example.usermanagement.request.UpdateUserReq;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com","0987654321","avatar.img","123"));
        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com","0123456789","avatar1.img","123"));
        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com","0987564664","avatar3.img","123"));
        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com","0874845455","avatar9.img","123"));
    }

    @Override
    public List<User> getUser() {
        return users;
    }

    @Override
    public List<UserDto> getUserDTO() {
        List<UserDto> listUserDTO = new ArrayList<>();
        for(User user : users) {
            listUserDTO.add(UserMapper.toUserDTO(user));
        }
        return listUserDTO;
    }

    @Override
    public UserDto getUserById(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return UserMapper.toUserDTO(user);
            }
        }
        throw new NotFoundException("No user found");
    }

    @Override
    public UserDto getUserByName(String name) {
        for(User user : users) {
            if(user.getName().equals(name)) {
                return UserMapper.toUserDTO(user);
            }
        }
        throw new NotFoundException("No user found");
    }

    @Override
    public UserDto createUserReq(CreateUserReq createUserReq) {
        User user = new User();
        user.setId(user.getId() + 1);
        user.setName(createUserReq.getName());
        user.setEmail(createUserReq.getEmail());
        user.setPassword(createUserReq.getPassword());
        user.setPhone(createUserReq.getPhone());
        users.add(user);
        return UserMapper.toUserDTO(user);
    }

    @Override
    public UserDto updateUser(UpdateUserReq updateUserReq,int id) {
        for (User user : users) {
            if (user.getId() == id) {
                if (!user.getEmail().equals(updateUserReq.getEmail())) {
                    // Check new email exist
                    for (User tmp : users) {
                        if (tmp.getEmail().equals(updateUserReq.getEmail())) {
                            throw new DuplicateRequestException("New email already exists in the system");
                        }
                    }
                    user.setEmail(updateUserReq.getEmail());
                }
                user.setName(updateUserReq.getName());
                user.setPhone(updateUserReq.getPhone());
                user.setAvatar(updateUserReq.getAvatar());
                user.setPassword(updateUserReq.getPassword());
                return UserMapper.toUserDTO(user);
            }
        }

        throw new NotFoundException("No user found");
    }

    @Override
    public boolean removeUser(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        throw new NotFoundException("No user found");
    }


}
