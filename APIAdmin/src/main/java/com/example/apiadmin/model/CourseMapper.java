package com.example.apiadmin.model;

import com.example.apiadmin.model.DTO.CourseDTO;

public class CourseMapper {
    public static CourseDTO toCourseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDesc(course.getDesc());
        courseDTO.setType(course.getType());
        courseDTO.setTopics(course.getTopics());
        courseDTO.setThumbnail(course.getThumbnail());
        courseDTO.setUser(new CourseDTO().getUser());
        return courseDTO;
    }
}
