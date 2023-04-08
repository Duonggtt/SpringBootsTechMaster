package com.example.usermanagement.model.mapper;

import com.example.usermanagement.model.entity.User;
import com.example.usermanagement.model.entity.UserDto;

public class UserMapper {
    public static UserDto toUserDTO(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAvatar(user.getAvatar());
        return userDto;
    }
}
