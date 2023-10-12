package vn.techmaster.blogapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.blogapp.model.request.UpsertBlogRequest;
import vn.techmaster.blogapp.model.request.UpsertTopicRequest;
import vn.techmaster.blogapp.service.CategoryService;

@RestController
@RequestMapping("/api/v1/admin/categories")
public class CategoryResource {
    // Tạo mới
    // yêu cầu không được trùng tên category. Nếu trùng -> throw BadRequestException

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody UpsertTopicRequest request) {
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }



    // Cập nhập
    // yêu cầu không được trùng tên category. Nếu trùng -> throw BadRequestException

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlog(@RequestBody UpsertTopicRequest request, @PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    // Xóa
    // Nếu category đang được sử dụng thì không được xóa. Nếu đang được sử dụng -> throw BadRequestException

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
