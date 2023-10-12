package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Librarian;
import com.example.librarywebproject.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News , Integer> {
    List<News> findByTitle(String title);
    List<News> findByPublishedAt(Date publishedAt);
    List<News> findByLibrarian(Librarian librarian);
    List<News> findAll();
    News findById(int id);
}
