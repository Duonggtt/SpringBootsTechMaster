package com.example.libexpress.controller;

import com.example.libexpress.entity.Author;
import com.example.libexpress.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lib-express/admin/authors")
public class AuthorController {


    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public String viewHomePage(Model model) {
        String keyword =null;
        return findPaginated(1, "name", "asc",keyword,model);
    }

    @GetMapping("/page/{page}")
    public String findPaginated(@PathVariable(value = "page") Integer page,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                Model model) {
        int limit = 10;
        Page<Author> getAuthorPage = authorService.findPaginated(page, limit, sortField, sortDirection,keyword);
        List<Author> authorList = getAuthorPage.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", getAuthorPage.getTotalPages());
        model.addAttribute("totalItems", getAuthorPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("pageData", getAuthorPage);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reverseSortDir",sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("BookList", authorList);
        model.addAttribute("keyword", keyword);
        return "admin/bookManagement/author";
    }
}
