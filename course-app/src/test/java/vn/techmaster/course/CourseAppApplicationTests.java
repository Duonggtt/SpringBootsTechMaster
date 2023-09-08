package vn.techmaster.course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.model.User;
import vn.techmaster.course.repository.UserRepository;
import vn.techmaster.course.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CourseAppApplicationTests {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveAllUser() {

        User user = new User(1, "Duc Thinh", "thinh@gmail.com", "0988888888", "https://media.techmaster.vn/api/static/c2m5ou451cob24f6skeg/c3IwVOU2");
        User user1 = new User(2, "Pham Man", "man@gmail.com", "0988888887", "https://media.techmaster.vn/api/static/crop/bv9jp4k51co7nj2mhht0");
        User user2 = new User(3, "Thanh Huong", "huong@gmail.com", "0988888886", "https://media.techmaster.vn/api/static/crop/brm3huc51co50mv77sag");

        userRepository.saveAll(List.of(user,user1,user2));
    }
}
