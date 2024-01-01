package com.example.libexpress.repository;

import com.example.libexpress.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT DISTINCT b FROM Book b JOIN b.categories c WHERE "
            + "CONCAT(b.id, b.title, b.author.name, b.publisher.name, c.name) "
            + "LIKE %?1%")
    Page<Book> findAll(String keyword, Pageable pageable);

    List<Book> findAllById(Integer bookId);
}
