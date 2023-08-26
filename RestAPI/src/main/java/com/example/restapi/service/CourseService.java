package com.example.restapi.service;

import com.example.restapi.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(String type, String name, String topic);

    Course getCourseById(Integer id);
}
