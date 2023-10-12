package vn.techmaster.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import vn.techmaster.blogapp.entity.Category;
import vn.techmaster.blogapp.model.dto.CategoryDto;
import vn.techmaster.blogapp.repository.CategoryRepository;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/admin/categories")
    public String getAllCategories(Model model) {
        List<CategoryDto> categoryDtoList = categoryRepository.getAllCategoryDtoNQ();
        model.addAttribute("categoryList", categoryDtoList);
        return "admin/category/index";
    }

}
