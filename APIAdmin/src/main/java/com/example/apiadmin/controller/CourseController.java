package com.example.apiadmin.controller;

import com.example.apiadmin.model.DTO.CourseDTO;
import com.example.apiadmin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public ResponseEntity<?> getAllCourse() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDTO);
    }
}
