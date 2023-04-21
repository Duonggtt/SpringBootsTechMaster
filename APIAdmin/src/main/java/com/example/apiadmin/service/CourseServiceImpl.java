package com.example.apiadmin.service;

import com.example.apiadmin.Exception.NotFoundException;
import com.example.apiadmin.model.*;
import com.example.apiadmin.model.DTO.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    private List<Course> courses = new ArrayList<>();
    private List<PageRequest> admins = new ArrayList<>();

    public List<PageRequest> getAdminCourse() {
        admins.add(new PageRequest(1,10,2,19,courses));
        return admins;
    }


    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public CourseDTO getCourseById(int id) {
        for(Course cour:courses) {
            if(cour.getId() == id) {
                return CourseMapper.toCourseDTO(cour);
            }
        }
        throw new NotFoundException("Not found");
    }

    @Override
    public CourseDTO createAdminCourse(CreateCourseReq req) {
        Course course = new Course();
        course.setId(req.getId());
        course.setName(req.getName());
        course.setDesc(req.getDesc());
        course.setType(req.getType());
        course.setTopics(req.getTopics());
        course.setThumbnail(req.getThumbnail());
        course.setUser(req.getUser());
        courses.add(course);
        return CourseMapper.toCourseDTO(course);
    }

    @Override
    public CourseDTO getAdminCourseById(int id) {
        for(Course cor:courses) {
            if(cor.getId()==id) {
                return CourseMapper.toCourseDTO(cor);
            }
        }
        throw new NotFoundException("Not found id");
    }

    @Override
    public CourseDTO updateAdminCourse(UpdateCourseReq req, int id) {
        for(Course cor:courses) {
            if(cor.getId() == id) {
                cor.setName(req.getName());
                cor.setDesc(req.getDesc());
                cor.setType(req.getType());
                cor.setTopics(req.getTopics());
                cor.setThumbnail(req.getThumbnail());
                cor.setUser(req.getUser());
            }
        }
        throw new NotFoundException("Not found id");
    }

    @Override
    public boolean removeAdminCourse(int id) {
        for(Course cor:courses) {
            if(cor.getId()==id) {
                courses.remove(cor);
                return true;
            }
        }
        throw new NotFoundException("Not found id");
    }

}
