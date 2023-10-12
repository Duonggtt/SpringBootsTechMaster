package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Book;
import com.example.librarywebproject.entity.Comment;
import com.example.librarywebproject.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPublishedAt(Date publishedAt);
    List<Comment> findByReader(Reader reader);
    List<Comment> findByBook(Book book);
    Comment findById(int id);
}
