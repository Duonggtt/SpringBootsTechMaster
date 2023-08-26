package com.example.restapi.service;

import com.example.restapi.DAO.CourseDAO;
import com.example.restapi.db.CourseDb;
import com.example.restapi.entity.Course;
import com.example.restapi.exeption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceIpml implements CourseService{

    @Autowired
    private CourseDAO courseDAO;
    @Override
    public List<Course> getAllCourses(String type, String name, String topic) {
        return courseDAO.getAllCourses(type,name,topic);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDAO.findById(id);
    }
}
