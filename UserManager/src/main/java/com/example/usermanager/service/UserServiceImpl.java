package com.example.usermanager.service;

import com.example.usermanager.exception.NotFoundException;
import com.example.usermanager.mapper.UserMapper;
import com.example.usermanager.model.User;
import com.example.usermanager.model.UserDto;
import com.example.usermanager.request.CreateUserReq;
import com.example.usermanager.request.UpdateUserReq;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Bùi Hiên", "buihien01091997@gmail.com","0344005816","Tỉnh Thái Bình","null","123"));
        users.add(new User(2, "Nguyễn Thu Hằng", "thuhangvnua@gmail.com","0123456789","Tỉnh Nam Định","null","123"));
        users.add(new User(3, "Bùi Phương Loan", "hien@techmaster.vn","0123456789","Tỉnh Hưng Yên","null","123"));
    }

    @Override
    public List<User> getUserList() {

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
        for(User user : users) {
            if(user.getEmail().equals(createUserReq.getEmail())) {
                throw new DuplicateRequestException("Email da ton tai!");
            }
        }
        User user = new User();
        user.setId(createUserReq.getId() + 1);
        user.setName(createUserReq.getName());
        user.setEmail(createUserReq.getEmail());
        user.setPhone(createUserReq.getPhone());
        user.setAddress(createUserReq.getAddress());
        user.setAvatar(createUserReq.getAvatar());
        user.setPassword(createUserReq.getPassword());

        users.add(user);
        return UserMapper.toUserDTO(user);
    }

    @Override
    public UserDto updateUser(UpdateUserReq updateUserReq, int id) {
        for(User user : users) {
            if(user.getId() == id) {
                user.setId(updateUserReq.getId() + 1);
                user.setName(updateUserReq.getName());
                user.setEmail(updateUserReq.getEmail());
                user.setPhone(updateUserReq.getPhone());
                user.setAddress(updateUserReq.getAddress());
                user.setAvatar(updateUserReq.getAvatar());
                user.setPassword(updateUserReq.getPassword());
            }
        }
        return null;
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

    @Override
    public User changePassword(UpdateUserReq updateUserReq, int id) {
        for(User user : users) {
            if(user.getId() == id) {
                user.setPassword(updateUserReq.getPassword());
                return user;
            }
        }
        throw new NotFoundException("No user found");
    }

    @Override
    public User forgotPassword(UpdateUserReq updateUserReq, int id) {
        for(User user : users) {
            if(user.getId() == id) {
                user.setPassword(updateUserReq.getPassword());
                return user;
            }
        }
        throw new NotFoundException("No user found");
    }
}
