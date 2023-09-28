package vn.techmaster.blogapp.service;

import com.github.slugify.Slugify;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.techmaster.blogapp.entity.Blog;
import vn.techmaster.blogapp.entity.Category;
import vn.techmaster.blogapp.entity.User;
import vn.techmaster.blogapp.exception.NotFoundException;
import vn.techmaster.blogapp.model.request.UpsertBlogRequest;
import vn.techmaster.blogapp.repository.BlogRepository;
import vn.techmaster.blogapp.repository.CategoryRepository;
import vn.techmaster.blogapp.repository.UserRepository;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;


    public BlogService(BlogRepository blogRepository,
                       CategoryRepository categoryRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public Page<Blog> findAll(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("publishedAt").descending());
        return blogRepository.findByStatus(true, pageable);
    }

    public List<Blog> searchByTitle(String title) {
        return blogRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Blog> findByCategoryName(String name) {
        return blogRepository.findByCategoryName(name);
    }

    public Blog findByIdAndSlug(Integer id, String slug) {
        return blogRepository.findByIdAndSlugAndStatusTrue(id, slug)
                .orElseThrow(() -> new NotFoundException("Cannot find blog"));
    }


    public  Page<Blog> getAllBlogsOfCurrentUser(Integer page, Integer limit) {
        //TODO: giai dinh userId = 1 sau nay userId chinh la user dang login

        Integer userId = 1;

        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("publishedAt").descending());
        return blogRepository.findByStatus(true, pageable);
    }

    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find blog"));
    }

    public Blog createBlog(UpsertBlogRequest request) {
        Blog blog = new Blog();
        Slugify slugify = Slugify.builder().build();

        User user = userRepository.findById(1)
                .orElseThrow(() -> new NotFoundException("Cannot find user"));

        blog.setTitle(request.getTitle());
        blog.setSlug(slugify.slugify(request.getTitle()));
        blog.setDescription(request.getDescription());
        blog.setContent(request.getContent());
        blog.setThumbnail(request.getThumbnail());
        blog.setStatus(request.getStatus());
        blog.setUser(user);

        List<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());
        blog.setCategories(categories);

        return blogRepository.save(blog);
    }

    public Blog updateBlog(UpsertBlogRequest request, Integer id) {

        Slugify slugify = Slugify.builder().build();
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find blog"));

        User user = userRepository.findById(1)
                .orElseThrow(() -> new NotFoundException("Cannot find user"));

        blog.setTitle(request.getTitle());
        blog.setSlug(slugify.slugify(request.getTitle()));
        blog.setDescription(request.getDescription());
        blog.setContent(request.getContent());
        blog.setThumbnail(request.getThumbnail());
        blog.setStatus(request.getStatus());
        blog.setUser(user);

        List<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());
        blog.setCategories(categories);

        return blogRepository.save(blog);
    }

    public void deleteBlog(Integer id) {
        blogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find blog"));

        blogRepository.deleteById(id);
    }
}
