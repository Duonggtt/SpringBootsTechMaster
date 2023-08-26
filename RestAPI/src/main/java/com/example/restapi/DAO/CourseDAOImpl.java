package com.example.restapi.DAO;

import com.example.restapi.db.CourseDb;
import com.example.restapi.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO{
    @Override
    public Course findById(Integer id){
        for(Course c:CourseDb.courseList) {
            if(c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses(String type, String name, String topic) {
        return CourseDb.courseList;
    }

}
