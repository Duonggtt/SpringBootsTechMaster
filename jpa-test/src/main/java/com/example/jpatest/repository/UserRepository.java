package com.example.jpatest.repository;

import com.example.jpatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    List<User> findByName(String name);

    List<User> findByNameStartWith(String name);

    List<User> findByNameConstainsIgnoreCase(String name);

    List<User> findByNameConstainsIgnoreCaseOrderByNameAsc(String name);

    List<User> findByNameOrEmailContains(String name, String email);

    List<User> findByNameLikeOrEmailLike(String name, String email);

    @Query(value = "SELECT * from user where username like :nameOrEmail OR email like :nameOrEmail", nativeQuery = true)
    List<User> getUserContainsNameOrEmail(@Param("nameOrEmail") String nameOrEmail);
}
