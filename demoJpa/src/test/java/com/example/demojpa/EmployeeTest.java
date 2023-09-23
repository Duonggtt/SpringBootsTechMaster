package com.example.demojpa;

import com.example.demojpa.entity.Employee;
import com.example.demojpa.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findByDepartmentTest() {
        List<Employee> employeeList = employeeRepository.findByDepartmentJPQL("A");
        employeeList.forEach(System.out::println);

        List<Employee> employeeList1 = employeeRepository.findByDepartmentJPQL1("A");
        employeeList1.forEach(System.out::println);

        List<Employee> employeeList2 = employeeRepository.findByDepartmentNQ("A");
        employeeList2.forEach(System.out::println);
    }

}
