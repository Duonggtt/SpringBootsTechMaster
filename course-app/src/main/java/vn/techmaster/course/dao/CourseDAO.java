package vn.techmaster.course.dao;

import vn.techmaster.course.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDAO {
    List<Course> findAll();

    boolean deleteCourse(Integer id);

    Optional<Course> findById(Integer id);


}
