package com.example.libexpress.controller;

import com.example.libexpress.entity.Author;
import com.example.libexpress.entity.Book;
import com.example.libexpress.entity.Category;
import com.example.libexpress.entity.Publisher;
import com.example.libexpress.model.dto.UserDto;
import com.example.libexpress.repository.AuthorRepository;
import com.example.libexpress.repository.CategoryRepository;
import com.example.libexpress.repository.PublisherRepository;
import com.example.libexpress.service.BookService;
import com.example.libexpress.service.CategoryService;
import com.example.libexpress.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lib-express/admin/books")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;
    private final ImageService imageService;
    public BookController(BookService bookService, CategoryService categoryService, ImageService imageService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.imageService = imageService;
    }

    @GetMapping("")
    public String viewHomePage(Model model) {
        String keyword =null;
        return findPaginated(1, "title", "asc",keyword,model);
    }

    @GetMapping("/page/{page}")
    public String findPaginated(@PathVariable(value = "page") Integer page,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                Model model) {
        int limit = 10;
        Page<Book> getBookPage = bookService.findPaginated(page, limit, sortField, sortDirection,keyword);
        List<Book> bookList = getBookPage.getContent();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", getBookPage.getTotalPages());
        model.addAttribute("totalItems", getBookPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("pageData", getBookPage);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reverseSortDir",sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("bookList", bookList);
        model.addAttribute("categoryList" ,categoryList);
        model.addAttribute("keyword", keyword);
        return "admin/bookManagement/book";
    }

    @GetMapping("/{id}/detail")
    public String getBookDetailPage(@PathVariable Integer id, Model model) {
        Book book = bookService.getBookById(id);
        List<Category> categoryList = categoryService.findAll();
        List<Author> authorList = authorRepository.findAll();
        List<Publisher> publisherList = publisherRepository.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("authorList", authorList);
        model.addAttribute("publisherList", publisherList);
        model.addAttribute("book", book);
        model.addAttribute("imageList", imageService.getFilesOfCurrentUser());
        return "admin/bookManagement/book-detail";
    }

    @GetMapping("/create")
    public String getUserCreatePage(Model model) {

        List<Author> authorList = authorRepository.findAll();
        List<Publisher> publisherList = publisherRepository.findAll();
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("authorList", authorList);
        model.addAttribute("publisherList", publisherList);
        model.addAttribute("categoryList", categoryList);
        return "admin/bookManagement/book-create";
    }
}
