package com.example.blogprj.repository;

import com.example.blogprj.model.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDtoRepository extends JpaRepository<CategoryDto,Integer> {
}
