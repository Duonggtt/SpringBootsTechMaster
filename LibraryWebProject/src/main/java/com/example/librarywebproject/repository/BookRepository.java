package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Book;
import com.example.librarywebproject.entity.PublishCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll();
    List<Book> findAllByTitle(String title);
    Book findById(int id);
    List<Book> findByPublishCompany(PublishCompany publishCompany);

    List<Book> findByCreatedAt(Date createdAt);

    List<Book> findByPublishedAt(Date publishedAt);
    List<Book> findByCopiesAvailable(int copiesAvailable);

    List<Book> findAllByOrderByTitleAsc();

    List<Book> findAllByOrderByPublishedAtAsc();

    List<Book> findByAuthorName(String authorName);

    Page<Book> findAll(Pageable pageable);

    @Query("""
        SELECT b
        FROM Book b
        JOIN b.categories c
        WHERE c.name = ?1 AND b.status = true
        ORDER BY b.publishedAt DESC
    """)
    List<Book> findAllByCategory(String name);
}
