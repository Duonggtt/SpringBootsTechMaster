package com.example.librarywebproject.service;

import com.example.librarywebproject.entity.Book;
import com.example.librarywebproject.repository.AuthorRepository;
import com.example.librarywebproject.repository.BookRepository;
import com.example.librarywebproject.repository.ReaderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final ReaderRepository readerRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BookService(ReaderRepository readerRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.readerRepository = readerRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Page<Book> findAll(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("publishedAt").descending());
        return bookRepository.findAll(pageable);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public List<Book> findByCategoryName(String name) {
        return bookRepository.findAllByCategory(name);
    }
}
