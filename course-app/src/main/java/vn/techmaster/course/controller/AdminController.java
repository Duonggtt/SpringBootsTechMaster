package vn.techmaster.course.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.course.dto.CourseDto;
import vn.techmaster.course.service.AdminService;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("api/v1/admin/courses")
public class AdminController {
    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String topic) {
        List<CourseDto> courseDtoList = adminService.getAllCourse(type, name, topic);
        return ResponseEntity.ok(courseDtoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Integer id) {
        CourseDto courseDto = adminService.getCourseById(id);
        return ResponseEntity.ok(courseDto);
    }

}
