package com.example.libexpress.controller;

import com.example.libexpress.entity.Author;
import com.example.libexpress.entity.Category;
import com.example.libexpress.entity.LibraryCard;
import com.example.libexpress.model.dto.UserDto;
import com.example.libexpress.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lib-express/admin/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
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
        Page<Category> getCategoryPage = categoryService.findPaginated(page, limit, sortField, sortDirection,keyword);
        List<Category> categoryList = getCategoryPage.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", getCategoryPage.getTotalPages());
        model.addAttribute("totalItems", getCategoryPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("pageData", getCategoryPage);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reverseSortDir",sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("keyword", keyword);
        return "admin/bookManagement/category";
    }

}
