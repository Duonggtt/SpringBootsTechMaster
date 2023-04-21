package com.example.apiadmin.service;

import com.example.apiadmin.model.Course;
import com.example.apiadmin.model.CreateCourseReq;
import com.example.apiadmin.model.DTO.CourseDTO;
import com.example.apiadmin.model.PageRequest;
import com.example.apiadmin.model.UpdateCourseReq;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface CourseService {

    List<Course> getAllCourses();
    CourseDTO getCourseById(int id);

    CourseDTO createAdminCourse(CreateCourseReq req);
    CourseDTO getAdminCourseById(int id);
    CourseDTO updateAdminCourse(UpdateCourseReq re,int id);

    boolean removeAdminCourse(int id);

    List<PageRequest> getAdminCourse();
}
