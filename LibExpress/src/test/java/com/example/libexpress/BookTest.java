package com.example.libexpress;

import com.example.libexpress.entity.Author;
import com.example.libexpress.entity.Book;
import com.example.libexpress.entity.Category;
import com.example.libexpress.entity.Publisher;
import com.example.libexpress.repository.AuthorRepository;
import com.example.libexpress.repository.BookRepository;
import com.example.libexpress.repository.CategoryRepository;
import com.example.libexpress.repository.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.List;

@SpringBootTest
public class BookTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void save_author() {
        for(int i =0;i<10;i++) {
            Author author = new Author();
            author.setName("author " + i);
            author.setBirthDate(new Date());
            authorRepository.save(author);
        }
    }

    @Test
    public void save_publisher() {
        for(int i =0;i<10;i++) {
            Publisher publisher = new Publisher();
            publisher.setName("publisher " + i);
            publisherRepository.save(publisher);
        }
    }

    @Test
    public void save_category() {
        for(int i =0;i<12;i++) {
            Category category = new Category();
            category.setName("category " + i);
            categoryRepository.save(category);
        }
    }

    @Test
    public void save_book() {
        List<Author> authorList = authorRepository.findAll();
        List<Publisher> publisherList = publisherRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        for(int i =1;i<15;i++) {
            Book book = new Book();
            book.setTitle("title " + i);

            Random random = new Random();
            int randomIndex = random.nextInt(authorList.size());
            book.setAuthor(authorList.get(randomIndex));

            int randomIndex1 = random.nextInt(publisherList.size());
            book.setPublisher(publisherList.get(randomIndex1));

            book.setPublishYear(2023);
            book.setQuantity(12);
            book.setSummaryContent("content " + i);
            book.setPrice(20000);
            book.setThumbnail("thumbnail " + i);

            // Random 1 ds category tuong ung
            Random rd = new Random();
            List<Category> rdList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Category rdCategory = categoryList.get(rd.nextInt(categoryList.size()));
                if(!rdList.contains(rdCategory)) {
                    rdList.add(rdCategory);
                }
            }
            book.setCategories(rdList);

            bookRepository.save(book);
        }
    }
    @Test
    public void test_book() {
        List<Book> bookList = bookRepository.findAll();
        for(int i = 0;i< bookList.size();i++) {
            System.out.print(bookList.get(i));
        }
    }
}
