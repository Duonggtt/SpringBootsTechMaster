package com.example.usermanager.mapper;

import com.example.usermanager.model.User;
import com.example.usermanager.model.UserDto;

public class UserMapper {
    public static UserDto toUserDTO(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setAvatar(user.getAvatar());
        return userDto;
    }
}
