package com.example.restapi.controller;

import com.example.restapi.DAO.CourseDAO;
import com.example.restapi.entity.Course;
import com.example.restapi.service.CourseService;
import com.example.restapi.service.CourseServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping()
    public ResponseEntity<?> getAllCourses(@RequestParam(required = false) String type, @RequestParam(required = false) String name, @RequestParam(required = false) String topic) {

        return ResponseEntity.ok(courseService.getAllCourses(type,name,topic));
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Integer id) {

        return ResponseEntity.ok(courseService.getCourseById(id));
    }

}
