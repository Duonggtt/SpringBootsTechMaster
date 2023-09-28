package vn.techmaster.blogapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.blogapp.entity.Blog;
import vn.techmaster.blogapp.entity.Category;
import vn.techmaster.blogapp.repository.BlogRepository;
import vn.techmaster.blogapp.service.BlogService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final BlogService blogService;
    private final BlogRepository blogRepository;

    public AdminController(BlogService blogService,
                           BlogRepository blogRepository) {
        this.blogService = blogService;
        this.blogRepository = blogRepository;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "admin/blog/index";
    }

    @GetMapping("/blogs")
    public String getAllBlogs(Model model) {
        Page<Blog> blogPage = blogService.findAll(1, 10);
        List<Blog> blogList = blogRepository.saveAllAndFlush(blogPage);
        model.addAttribute("currentPage", 1);
        model.addAttribute("pageData", blogPage);
        model.addAttribute("blogList", blogList);
        return "admin/blog/blog-index";
    }


    @GetMapping("/blogs/{id}")
    public String getDetailBlog(Model model, @PathVariable Integer id) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog",blog);
        return "admin/blog/detail";
    }

    @GetMapping("/blog/create")
    public String getCreatePage() {
        return "admin/blog/create";
    }
}
