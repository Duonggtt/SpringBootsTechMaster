package vn.techmaster.course.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.techmaster.course.dao.CourseDAO;
import vn.techmaster.course.dao.UserDAO;
import vn.techmaster.course.db.CourseDB;
import vn.techmaster.course.dto.CourseDto;
import vn.techmaster.course.dto.UpsertCourseRequest;
import vn.techmaster.course.exception.ResouceNotFoundException;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.model.User;
import vn.techmaster.course.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final CourseDAO courseDAO;
    private final UserDAO userDAO;

    public AdminServiceImpl(CourseDAO courseDAO, UserDAO userDAO) {
        this.courseDAO = courseDAO;
        this.userDAO = userDAO;
    }

    @Override
    public List<CourseDto> getAllCourse(String type, String name, String topic) {
        List<Course> courseList = courseDAO.findAll();
        return courseList.stream()
                .filter(course -> (type == null || course.getType().equals(type))
                        && (name == null || course.getName().toLowerCase().contains(name.toLowerCase()))
                        && (topic == null || course.getTopics().contains(topic)))
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Course createCourse(UpsertCourseRequest courseRequest) {
        validateUpsertCourseRequest(courseRequest);

        Course course = new Course();
        course.setId(courseRequest.getId());
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setType(courseRequest.getType());
        course.setTopics(courseRequest.getTopics());
        course.setThumbnail(courseRequest.getThumbnail());
        course.setUserId(courseRequest.getUserId());

        CourseDB.courseList.add(course);
        return course;
    }

    @Override
    public CourseDto getCourseById(Integer id) {
        Course course = courseDAO.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("Not found course"));

        return mapToDto(course);
    }

    @Override
    public CourseDto updateCourse(Integer id, UpsertCourseRequest courseRequest) {
        return null;
    }

    @Override
    public void deleteCourse(Integer id) {

    }

    private CourseDto mapToDto(Course course) {
        User user = userDAO.findById(course.getUserId())
                .orElseThrow(() -> new ResouceNotFoundException("Not found user"));
        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .type(course.getType())
                .topics(course.getTopics())
                .thumbnail(course.getThumbnail())
                .user(user)
                .build();
    }

    private void validateUpsertCourseRequest(UpsertCourseRequest request) {

        if (request.getName() == null || request.getName().isEmpty()
                || request.getDescription() == null || request.getDescription().isEmpty()
                || request.getType() == null || request.getType().isEmpty()
                || request.getUserId() == null || request.getTopics() == null || request.getTopics().isEmpty()) {
            throw new IllegalArgumentException("Required fields are missing");
        }

        if (request.getDescription().length() <= 50) {
            throw new IllegalArgumentException("Description must be longer than 50 characters");
        }
    }

}
