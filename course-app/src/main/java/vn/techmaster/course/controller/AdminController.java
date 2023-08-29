package vn.techmaster.course.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.course.dto.CourseDto;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.request.UpsertCourseRequest;
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

    @PostMapping
    private ResponseEntity<?> createNewCourse(@Valid @RequestBody UpsertCourseRequest request){
        Course course = adminService.createCourse(request);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        CourseDto course = adminService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @Valid @RequestBody UpsertCourseRequest request) {

        Course course = adminService.updateCourse(id,request);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> dateleCourse(@PathVariable Integer id) {
        adminService.deleteCourse(id);
        return null;
    }

}
