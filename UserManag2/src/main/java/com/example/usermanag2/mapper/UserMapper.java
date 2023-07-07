package com.example.usermanag2.mapper;

import com.example.usermanag2.dto.UserDTO;
import com.example.usermanag2.entity.User;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.getAvatar());
    }
}
