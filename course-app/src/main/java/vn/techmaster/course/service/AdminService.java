package vn.techmaster.course.service;

import vn.techmaster.course.dto.CourseDto;
import vn.techmaster.course.dto.UpsertCourseRequest;
import vn.techmaster.course.model.Course;

import java.util.List;

public interface AdminService {
    List<CourseDto> getAllCourse(String type, String name, String topic);

    Course createCourse(UpsertCourseRequest courseRequest);

    CourseDto getCourseById(Integer id);
    CourseDto updateCourse(Integer id, UpsertCourseRequest courseRequest);

    void deleteCourse(Integer id);
}
