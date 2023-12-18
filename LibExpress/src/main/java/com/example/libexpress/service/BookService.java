package com.example.libexpress.service;

import com.example.libexpress.entity.*;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.dto.UserDto;
import com.example.libexpress.model.request.UpsertBookRequest;
import com.example.libexpress.repository.AuthorRepository;
import com.example.libexpress.repository.BookRepository;
import com.example.libexpress.repository.CategoryRepository;
import com.example.libexpress.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Book> getAllBooks(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return bookRepository.findAll(pageRequest);
    }

    public Page<Book> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Book> bookPage;
        if(keyword != null) {
            bookPage = bookRepository.findAll(keyword,pageable);
        }else {
            bookPage = bookRepository.findAll(pageable);
        }

        List<Book> bookList = bookPage.getContent();

        return new PageImpl<>(bookList, pageable, bookPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Book createBook(UpsertBookRequest request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy tác giả có id = " + request.getAuthorId()));
        Publisher publisher = publisherRepository.findById(request.getPublisherId())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy NXB có id =" + request.getPublisherId()));

        List<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPublishYear(request.getPublishYear());
        book.setQuantity(request.getQuantity());
        book.setSummaryContent(request.getSummaryContent());
        book.setPrice(request.getPrice());
        book.setThumbnail(request.getThumbnail());
        book.setCategories(categories);
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(Integer id,UpsertBookRequest request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy tác giả có id = " + request.getAuthorId()));
        Publisher publisher = publisherRepository.findById(request.getPublisherId())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy NXB có id =" + request.getPublisherId()));

        List<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sách với id = " + id));

        book.setTitle(request.getTitle());
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPublishYear(request.getPublishYear());
        book.setQuantity(request.getQuantity());
        book.setSummaryContent(request.getSummaryContent());
        book.setPrice(request.getPrice());
        book.setThumbnail(request.getThumbnail());
        book.setCategories(categories);
        bookRepository.save(book);
        return book;
    }

    public Book getBookById(Integer id) {

        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sách với id= " + id));
    }
}
