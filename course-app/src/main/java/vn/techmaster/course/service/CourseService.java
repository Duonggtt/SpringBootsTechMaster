package vn.techmaster.course.service;

import vn.techmaster.course.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourse(String type, String name, String topic);

    CourseDto getCourseById(Integer id);


}
