package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("1");


        User user1 = new User();
        user.setUsername("2");


        User user2 = new User();
        user.setUsername("3");


        User user3 = new User();
        user.setUsername("4");


        User user4 = new User();
        user.setUsername("5");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
    }

}
