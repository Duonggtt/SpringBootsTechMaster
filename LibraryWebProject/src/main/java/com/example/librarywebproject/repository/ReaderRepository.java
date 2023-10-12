package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
    List<Reader> findByFullName(String fullName);
    Reader findById(int id);
    List<Reader> findAll();
    List<Reader> findByUsername(String username);
    List<Reader> findByAddress(String address);
    List<Reader> findByBirth(Date birth);
    List<Reader> findAllByOrderByFullNameDesc();
    @Query("SELECT r FROM Reader r ORDER BY YEAR(CURRENT_DATE) - YEAR(r.birth) DESC")
    List<Reader> findAllByOrderByAgeDesc();
}
