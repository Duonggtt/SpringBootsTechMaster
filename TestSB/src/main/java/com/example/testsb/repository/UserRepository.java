package com.example.testsb.repository;

import com.example.testsb.entity.User;
import com.example.testsb.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<UserDto> findByName(String name);
}
