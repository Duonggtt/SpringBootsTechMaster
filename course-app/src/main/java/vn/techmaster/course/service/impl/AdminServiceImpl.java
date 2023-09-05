package vn.techmaster.course.service.impl;

import org.springframework.stereotype.Service;
import vn.techmaster.course.dao.CourseDAO;
import vn.techmaster.course.dao.UserDAO;
import vn.techmaster.course.db.CourseDB;
import vn.techmaster.course.dto.CourseDto;
import vn.techmaster.course.request.UpsertCourseRequest;
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

        Course course = new Course();
        course.setId(createId());
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setType(courseRequest.getType());
        course.setTopics(courseRequest.getTopics());
        course.setThumbnail(courseRequest.getThumbnail());
        course.setUserId(courseRequest.getUserId());

        CourseDB.courseList.add(course);
        return course;
    }


    private Integer createId() {
        Integer id = CourseDB.courseList.size();
        id++;
        return id;
    }
    @Override
    public CourseDto getCourseById(Integer id) {
        Course course = courseDAO.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("Not found course"));

        return mapToDto(course);
    }


    @Override
    public Course updateCourse(Integer id, UpsertCourseRequest courseRequest) {

        for(Course course: CourseDB.courseList) {
            if (course.getId().equals(id)) {
                course.setName(courseRequest.getName());
                course.setDescription(courseRequest.getDescription());
                course.setType(courseRequest.getType());
                course.setTopics(courseRequest.getTopics());
                course.setThumbnail(courseRequest.getThumbnail());
                course.setUserId(courseRequest.getUserId());

                CourseDB.courseList.add(course);
                break;
            }
        }
        return null;
    }

    @Override
    public void deleteCourse(Integer id) {
        courseDAO.deleteCourse(id);
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


}
