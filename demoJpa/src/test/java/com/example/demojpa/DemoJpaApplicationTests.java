package com.example.demojpa;

import com.example.demojpa.entity.Employee;
import com.example.demojpa.entity.Student;
import com.example.demojpa.repository.EmployeeRepository;
import com.example.demojpa.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void saveStudent() {
        Student student = new Student(null, "DuongTung", "duonggtung@gmail.com",20);
        studentRepository.save(student);
    }

    @Test
    void saveStudents() {
        Student student = new Student(null, "Lanh", "lanh173@gmail.com",19);
        Student student1 = new Student(null, "Student1", "abc173@gmail.com",22);
        studentRepository.saveAll(List.of(student,student1));
    }

    @Test
    void getAllStudent() {
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }

    @Test
    void getStudentById() {
        Student student = studentRepository.findById(4).orElse(null);
        System.out.println(student);
    }

    @Test
    void updateStudent() {
        Student student = studentRepository.findById(4).orElse(null);
        student.setName("Tam");
        studentRepository.save(student);
    }

    @Test
    void deleteStudent() {
        Student student = studentRepository.findById(6).orElse(null);
        studentRepository.delete(student);
    }

    @Test
    void findByEmail() {
        Optional<Student> student = studentRepository.findByEmail("duonggtung173@gmail.com");
        System.out.println(student);
    }

    @Test
    void findByNameContainsIgnoreCase() {
        List<Student> students = studentRepository.findByNameContainsIgnoreCase("duong");
        System.out.println(students);
    }

    @Test
    void saveAllStudent() {
        Faker faker = new Faker();
        for(int i = 0;i< 100;i++) {
            Student student = new Student(
                    null,
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.number().numberBetween(18,50)
            );
            studentRepository.save(student);
        }
    }

    @Test
    void saveAllEmployee() {
        Faker faker = new Faker();
        Date from = new Date(123456789L);
        Date to = new Date(123456789L);
        for(int i = 0;i< 50;i++) {
            Employee employee = new Employee(
                    (Integer) null,
                    faker.name().fullName(),
                    faker.commerce().department(),
                    (long) faker.number().numberBetween(1000,9999999),
                    faker.date().birthday()
            );
            employeeRepository.save(employee);
        }
    }

}
