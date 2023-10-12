package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    List<Librarian> findByFullName(String fullName);
    List<Librarian> findByUsername(String username);
    List<Librarian> findAll();
    Librarian findById(int id);
}
