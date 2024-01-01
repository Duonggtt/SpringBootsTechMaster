package com.example.libexpress.repository;

import com.example.libexpress.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select  c from Category  c where "
            + "concat(c.id, c.name)"
            + "LIKE %?1%")
    Page<Category> findAll(String keyword, Pageable pageable);

    List<Category> findByIdIn(List<Integer> categoryIds);

}
