package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Card;
import com.example.librarywebproject.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findByReader(Reader reader);
    List<Card> findByUpdatedAt(Date updatedAt);
    List<Card> findByCreatedAt(Date createdAt);
    Card findById(int id);
}
