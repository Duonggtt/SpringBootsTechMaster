package vn.techmaster.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.course.db.TopicDB;
import vn.techmaster.course.db.UserDB;
import vn.techmaster.course.dto.CourseDto;
import vn.techmaster.course.model.User;
import vn.techmaster.course.service.AdminService;

import java.util.List;

@Controller
public class AdminViewController {


    private final AdminService adminService;

    public AdminViewController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/admin/course")
    public String getCoursePage(Model model) {
        List<CourseDto> courseDtoList = adminService.getAllCourse(null,null,null);
        model.addAttribute("courseList", courseDtoList);
        model.addAttribute("topicList", TopicDB.topicList);
        return "admin-course-list";
    }

    @GetMapping("/admin/course/create")
    public String getCreateCoursePage() {
        return "admin-courseCreate";
    }

    @GetMapping("/admin/course/edit/{id}")
    public String getEditCoursePage(Model model, @PathVariable Integer id) {
        CourseDto courseDto = adminService.getCourseById(id);
        User user = courseDto.getUser();
        List<User> users = UserDB.userList;
        model.addAttribute("course",courseDto);
        model.addAttribute("user",user);
        model.addAttribute("userList",users);
        return "admin-courseEdit";
    }
}
