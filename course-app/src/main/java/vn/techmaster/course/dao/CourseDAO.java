package vn.techmaster.course.dao;

import vn.techmaster.course.model.Course;
import vn.techmaster.course.model.User;

import java.util.List;
import java.util.Optional;

public interface CourseDAO {
    List<Course> findAll();

    Optional<Course> findById(Integer id);

}
