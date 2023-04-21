package com.example.apiadmin.controller;

import com.example.apiadmin.model.*;
import com.example.apiadmin.model.DTO.CourseDTO;
import com.example.apiadmin.request.Page;
import com.example.apiadmin.request.PageRequest;
import com.example.apiadmin.request.PagedResponse;
import com.example.apiadmin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public ResponseEntity<?> getAdminCourse() {

        return ResponseEntity.ok(courseService.getAdminCourse());
    }

    @PostMapping("/course")
    public ResponseEntity<?> createCourse(@RequestBody CreateCourseReq course) {
        CourseDTO newCourse = courseService.createAdminCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        CourseDTO courseDto = courseService.getAdminCourseById(id);
        return ResponseEntity.ok(courseDto);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<?> updateCourseById(@PathVariable int id, @RequestBody UpdateCourseReq req) {
        CourseDTO updateCourse = courseService.updateAdminCourse(req,id);
        return ResponseEntity.ok(updateCourse);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> removeAdminCourseById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.removeAdminCourse(id));
    }

}
