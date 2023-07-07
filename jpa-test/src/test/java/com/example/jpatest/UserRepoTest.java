package com.example.jpatest;

import com.example.jpatest.entity.User;
import com.example.jpatest.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    void saveUser() {
        Faker faker = new Faker();
        List<User> users = new ArrayList<>();
        for(int i =0 ; i<30;i++) {
            User user = User.builder()
                    .fullName(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .phone("097288833")
                    .build();
            userRepository.saveAll(users);
        }
    }

    @Test
    void getAllUser() {
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(30);
    }

    @Test
    void testFindByName() {
        List<User> users = userRepository.findByName("Duong");
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getId()).isEqualTo(6);
    }

    @Test
    void testFindByNameStartWith() {
        List<User> users = userRepository.findByNameStartWith("Tran");
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getId()).isEqualTo(6);
    }

    @Test
    void testFindByNameConstainsIgnoreCase() {
        List<User> users = userRepository.findByNameConstainsIgnoreCase("hi");
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getId()).isEqualTo(6);
    }

    @Test
    void testFindByNameConstainsIgnoreCaseMultipleResults() {
        List<User> users = userRepository.findByNameConstainsIgnoreCaseOrderByNameAsc("hi");
        assertThat(users.size()).isEqualTo(5);
        assertThat(users.get(0).getId()).isEqualTo(11);
    }

    @Test
    void testFindByNameOrEmailContains() {
        List<User> users = userRepository.findByNameOrEmailContains("hi","12");
        assertThat(users.size()).isEqualTo(6);
        assertThat(users.get(0).getId()).isEqualTo(4);
    }

    @Test
    void testFindByNameLikeOrEmailLike() {
        List<User> users = userRepository.findByNameLikeOrEmailLike("hi","23");
        assertThat(users.size()).isEqualTo(6);
        assertThat(users.get(0).getId()).isEqualTo(4);
    }
}
