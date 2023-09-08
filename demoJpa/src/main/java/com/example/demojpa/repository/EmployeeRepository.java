package com.example.demojpa.repository;

import com.example.demojpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByDepartment(String department);

    List<Employee> findAllBySalaryGreaterThan(Long salary);

    List<Employee> findAllByName(String name);

    List<Employee> findAllByNameContainsIgnoreCase(String name);

    List<Employee> findAllByNameStartingWith(String name);

    List<Employee> findAllBySalaryBetween(Long minSalary, Long maxSalary);

    long countByDepartment(String department);

    List<Employee> findAllByNameContainsIgnoreCaseAndDepartment(String name, String department);

    List<Employee> findAllByNameOrDepartment(String name,String department);

    List<Employee> findAllByJoiningDate(Date joiningDate);

}
