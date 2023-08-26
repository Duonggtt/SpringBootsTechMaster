package com.example.restapi.db;

import com.example.restapi.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDb {
    public static List<User> userList = new ArrayList<>(
            List.of(
                    new User(1,"Duong Tung1","duonggtung173@gmail.com","0972433546","avatar1"),
                    new User(2,"Lan Anh2","duonggtung173@gmail.com","0972433546","avatar2"),
                    new User(3,"Viet Anh3","duonggtung173@gmail.com","0972433546","avatar3"),
                    new User(4,"Duong Tung4","duonggtung173@gmail.com","0972433546","avatar4"),
                    new User(5,"Duong Tung5","duonggtung173@gmail.com","0972433546","avatar5"),
                    new User(6,"Lan Anh6","duonggtung173@gmail.com","0972433546","avatar6"),
                    new User(7,"Duong Tung7","duonggtung173@gmail.com","0972433546","avatar7"),
                    new User(8,"Duong Tung8","duonggtung173@gmail.com","0972433546","avatar8"),
                    new User(9,"Duong Tung9","duonggtung173@gmail.com","0972433546","avatar9"),
                    new User(10,"Duong Tung10","duonggtung173@gmail.com","0972433546","avatar10")
            )
    );
}
