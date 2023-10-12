package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByOrderByNameDesc();
    List<Category> findAll();
    List<Category> findByName(String name);
}
