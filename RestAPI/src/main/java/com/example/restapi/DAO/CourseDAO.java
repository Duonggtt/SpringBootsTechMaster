package com.example.restapi.DAO;

import com.example.restapi.db.CourseDb;
import com.example.restapi.entity.Course;

import java.util.List;

public interface CourseDAO {
    Course findById(Integer id);

    List<Course> getAllCourses(String type, String name, String topic);
}
