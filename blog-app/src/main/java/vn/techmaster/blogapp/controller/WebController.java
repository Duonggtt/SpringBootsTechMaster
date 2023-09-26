package vn.techmaster.blogapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.blogapp.entity.Blog;
import vn.techmaster.blogapp.model.dto.CategoryDto;
import vn.techmaster.blogapp.repository.CategoryRepository;
import vn.techmaster.blogapp.service.BlogService;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {
    private final BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String getHome(Model model) {
        Page<Blog> pageData = blogService.findAll(1, 5);
        model.addAttribute("currentPage", 1);
        model.addAttribute("pageData", pageData);
        return "main";
    }

    @GetMapping("/page/{pageNumber}")
    public String getPage(Model model, @PathVariable Integer pageNumber) {
        Page<Blog> pageData = blogService.findAll(pageNumber, 5);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageData", pageData);
        return "page";
    }

    @GetMapping("search")
    public String searchBlog() {
        return null;
    }

    @GetMapping("categories")
    public String getAllCategory(Model model) {
        List<CategoryDto> categoryDto = categoryRepository.getAllCategoryDto();
        model.addAttribute("categoryList",categoryDto);
        return "tag";
    }

    @GetMapping("categories/{categoryName}")
    public String getBlogsOfCategory(Model model, @PathVariable String categoryName) {
        List<CategoryDto> categoryDtoList = categoryRepository.getAllCategoryDto();
        CategoryDto categoryDto = new CategoryDto();
        for(CategoryDto ctg: categoryDtoList) {
            if(ctg.getName().equals(categoryName)) {
                categoryDto = ctg;
            }
        }
        List<Blog> blogList = blogService.findByCategoryName(categoryName);
        model.addAttribute("blogList" , blogList);
        model.addAttribute("tag" , categoryDto);
        return "tagDetail";
    }

    @GetMapping("blogs/{blogId}/{blogSlug}")
    public String getBlogDetail(Model model, @PathVariable Integer blogId, @PathVariable String blogSlug) {
        Blog blog = blogService.findByIdAndSlug(blogId,blogSlug);
        model.addAttribute("blog",blog);
        return "blogDetail";
    }
}
