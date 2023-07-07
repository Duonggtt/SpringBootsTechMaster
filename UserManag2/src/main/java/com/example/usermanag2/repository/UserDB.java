package com.example.usermanag2.repository;

import com.example.usermanag2.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(List.of(
            User.builder().widthId(1).widthName("Lanh").widthPhone("0918223456").widthEmail("lnla123@gmail.com").widthAvatar("/img/avatar1").widthPassword("123").build(),
            User.builder().widthId(1).widthName("Duong").widthPhone("0918223456").widthEmail("duong123@gmail.com").widthAvatar("/img/avatar2").widthPassword("123").build(),
            User.builder().widthId(1).widthName("Bttb").widthPhone("0918223456").widthEmail("beo123@gmail.com").widthAvatar("/img/avatar3").widthPassword("123").build()
    ));
}
