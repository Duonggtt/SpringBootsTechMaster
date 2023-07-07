package com.example.blogprj.repository;

import com.example.blogprj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoles_NameIn(List<String> admin);
}
