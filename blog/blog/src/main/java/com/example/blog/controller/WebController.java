package com.example.blog.controller;

import com.example.blog.service.BlogService;
import com.example.blog.service.WebService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class WebController {

    private final WebService webService;

    private final BlogService blogService;

    //danh sach all bai viet
    @GetMapping("/")
    public String getAllBlog(@RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                             Model model) {

        Page<BlogPublic> publicPage = webService.getAllBlog(page - 1, pageSize);
        model.addAttribute("page",publicPage);
        return "main/blog/blog-index";
    }

    //danh sach bai viet cua toi
    @GetMapping("/admin/b;pgs/own-blogs")
    public String getOwnBlogPage(Model model) {
        List<BlogPublic> pageInfo = blogService.getAllOwnBlog();
        model.addAttribute("page", pageInfo);
        return "admin/blog/blog-index";

    }

    @GetMapping("blogs/search")
    public ResponseEntity<?> searchBlog(@RequestParam String term) {
        List<BlogPublic> blogPublicList = webService.searchBlog(term);
        return ResponseEntity.ok(blogPublicList);
    }

    @GetMapping("categories")
    public ResponseEntity<?> getAllCategory() {
        List<CategoryWebPublic> categoryList = webService.getAllCategory();
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("categories/top5")
    public ResponseEntity<?> getTop5Category() {
        List<CategoryWebPublic> categoryList = webService.getTop5Category();
        return ResponseEntity.ok(categoryList);
    }

    public ResponseEntity<?>

}
