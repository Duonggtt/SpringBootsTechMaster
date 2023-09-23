package com.example.demojpa;

import com.example.demojpa.entity.Student;
import com.example.demojpa.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentTest {

    private StudentRepository studentRepository;

    @Test
    void updateNameTest() {
        studentRepository.updateName(1,"Bui Hien");

        Optional<Student> st = studentRepository.findById(1);
        System.out.println(st);

        Assertions.assertNotNull(st);
    }


    @Test
    void deleteEmailTest() {
        studentRepository.deleteEmail("a@gmail.com");
    }

    @Test
    void pagingTest() {

        Page<Student> page = studentRepository.findAll(PageRequest.of(1, 5));

        page.getContent().forEach(System.out::println);
    }

    @Test
    void sortTest() {
        List<Student> students = studentRepository.findByAgeGreaterThanOrderByAgeAsc(40);
        students.forEach(System.out::println);


        List<Student> students2 = studentRepository.findByAgeGreaterThanNQ(40);
        students2.forEach(System.out::println);

        List<Student> students3 = studentRepository.findByAgeGreaterThan(40, Sort.by("age").ascending());
        students3.forEach(System.out::println);

    }

}
