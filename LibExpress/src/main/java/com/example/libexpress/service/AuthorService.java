package com.example.libexpress.service;

import com.example.libexpress.entity.Author;
import com.example.libexpress.entity.Book;
import com.example.libexpress.entity.Category;
import com.example.libexpress.entity.User;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.repository.AuthorRepository;
import com.example.libexpress.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public Page<Author> getAllAuthors(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return authorRepository.findAll(pageRequest);
    }

    public Page<Author> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Author> authorPage;
        if(keyword != null) {
            authorPage = authorRepository.findAll(keyword,pageable);
        }else {
            authorPage = authorRepository.findAll(pageable);
        }

        List<Author> authorList = authorPage.getContent();

        return new PageImpl<>(authorList, pageable, authorPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Author createAuthor(Author request) {
        Author author = new Author();
        author.setName(request.getName());
        author.setBirthDate(request.getBirthDate());
        authorRepository.save(author);
        return author;
    }

    public Author updateAuthor(Integer id, Author request) {
        List<Author> authorList = authorRepository.findAll();
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy tác giả có id " + id));

        author.setName(request.getName());
        author.setBirthDate(request.getBirthDate());
        authorRepository.save(author);
        return author;
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy tác giả có id " + id));
    }
}
