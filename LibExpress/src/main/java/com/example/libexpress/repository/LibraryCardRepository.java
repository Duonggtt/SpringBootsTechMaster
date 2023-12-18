package com.example.libexpress.repository;

import com.example.libexpress.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {

    LibraryCard findByUserId(Integer user_id);

    boolean existsById(Integer id);
}
