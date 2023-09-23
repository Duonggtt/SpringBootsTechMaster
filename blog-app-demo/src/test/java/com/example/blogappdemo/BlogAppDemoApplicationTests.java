package com.example.blogappdemo;

import com.example.blogappdemo.entity.*;
import com.example.blogappdemo.repository.*;
import com.example.blogappdemo.service.UserService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class BlogAppDemoApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BlogRepository blogRepository;


    private UserService userService;



    @Test
    void save_role() {

        //role
        List<Role> roleList = List.of(
                new Role(null, "Admin"),
                new Role(null, "User"),
                new Role(null, "Author")
        );
        roleRepository.saveAll(roleList);


        Role adminRole = roleRepository.findByName("Admin").orElse(null);
        Role userRole = roleRepository.findByName("User").orElse(null);
        Role authorRole = roleRepository.findByName("Author").orElse(null);


        //user
        List<User> userList = List.of(
                new User(null, "Duong Tung", "duong173@gmail.com", "avatar", "123", List.of(adminRole,userRole,authorRole)),
                new User(null, "Lan Anh", "lanh180@gmail.com","avatar1", "123", List.of(userRole)),
                new User(null, "Minh Tam", "tam123@gmail.com","avatar2", "123", List.of(authorRole)),
                new User(null, "Quang Huy", "huy@gmail.com","avatar3", "123", List.of(authorRole, userRole)),
                new User(null, "Gia Ngoc", "ngoc111@gmail.com","avatar4", "123", List.of(authorRole)),
                new User(null, "Anh Tuan", "tuananh@gmail.com","avatar5", "123", List.of(authorRole, userRole)),
                new User(null, "Quang Hieu", "hieu246@gmail.com","avatar6", "123", List.of(userRole)),
                new User(null, "Anh Nguyen", "nguyenanh@gmail.com","avatar7", "123", List.of(authorRole)),
                new User(null, "Anh Toan", "toan@gmail.com","avatar8", "123", List.of(authorRole)),
                new User(null, "Bui Tuan", "anhBui@gmail.com","avatar9", "123", List.of(authorRole, userRole)),
                new User(null, "Vu Anh", "vuanh@gmail.com","avatar10", "123", List.of(authorRole, userRole))
        );

        userRepository.saveAll(userList);

        //category
        List<Category> categoryList = List.of(
                new Category(null, "Novel"),
                new Category(null, "Comic"),
                new Category(null, "Mystery"),
                new Category(null, "Cookbooks"),
                new Category(null, "Self-help"),
                new Category(null, "Thrillers & Horror"),
                new Category(null, "Biography"),
                new Category(null, "Science fiction book"),
                new Category(null, "Fable"),
                new Category(null, "Fairy tale")
        );

        categoryRepository.saveAll(categoryList);

        //blog
        Random random = new Random();

        List<User> users = userRepository.findByRoles_NameIn(List.of("ADMIN", "AUTHOR"));

        for(int i = 0;i<20;i++) {
            User userRandom = users.get(random.nextInt(users.size()));

            List<Category> categoryListRandom = new ArrayList<>();
            for(int j =0;j< 5 ; j++) {
                Category categoryRandom = categoryList.get(random.nextInt(categoryList.size()));
                if(!categoryListRandom.contains(categoryRandom)) {
                    categoryListRandom.add(categoryRandom);
                }
            }

            List<String> status = List.of("200","204");

            Blog blog = Blog.builder()
                    .title("Blog " + (i + 1))
                    .slug("Blog " + (i + 1))
                    .description("Blog description " + (i + 1))
                    .content("Blog content " + (i + 1))
                    .status(status.get(random.nextInt(status.size())))
                    .user(userRandom)
                    .categoryList(categoryListRandom)
                    .build();

            blogRepository.save(blog);
        }


        //comment
        for(int j=0; j < 100;j++) {
            List<Blog> blogList = blogRepository.findAll();

            User userRandom = users.get(random.nextInt(users.size()));
            Blog blogRandom = blogList.get(random.nextInt(blogList.size()));

            Comment comment = Comment.builder()
                    .content("Comment from user " + (userRandom.getId()))
                    .user(userRandom)
                    .blog(blogRandom)
                    .build();

            commentRepository.save(comment);
        }

    }

}
