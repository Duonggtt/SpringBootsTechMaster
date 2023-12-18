package com.example.libexpress.repository;

import com.example.libexpress.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    @Query("select p from Publisher p where "
            + "concat(p.id, p.name)"
            + "LIKE %?1%")
    Page<Publisher> findAll(String keyword, Pageable pageable);
}
