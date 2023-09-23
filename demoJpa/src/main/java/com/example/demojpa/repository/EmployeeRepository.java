package com.example.demojpa.repository;

import com.example.demojpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("select e from Employee e where e.department = ?1")
    List<Employee> findByDepartmentJPQL(String department);


    @Query("select e from Employee e where e.department = :department")
    List<Employee> findByDepartmentJPQL1(@Param("department") String department);

    @Query(value = "select * from employee e where e.department = ?1", nativeQuery = true)
    List<Employee> findByDepartmentNQ(String department);

    @Query("select e from Employee e where e.department = ?1")
    List<Employee> findAllByDepartment(String department);

    @Query("select e from Employee e where e.salary >= ?1")
    List<Employee> findAllBySalaryGreaterThan(Long salary);

    @Query("select e from Employee e where e.name=?1")
    List<Employee> findAllByName(String name);

    @Query("select e from Employee e where e.name like concat('%', LOWER(?1) ,'%')")
    List<Employee> findAllByNameContainsIgnoreCase(String name);

    @Query("select e from Employee e where e.name= concat('%', lower(?1) )")
    List<Employee> findAllByNameStartingWith(String name);

    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> findAllBySalaryBetween(Long minSalary, Long maxSalary);

    @Query("select COUNT(e) from Employee e where e.department = ?1")
    long countByDepartment(String department);

    @Query("select e from Employee e where e.name like concat('%', LOWER(?1) ,'%') AND e.department = ?2")
    List<Employee> findAllByNameContainsIgnoreCaseAndDepartment(String name, String department);

    @Query("select e from Employee e where e.name = ?1 or e.department = ?2")
    List<Employee> findAllByNameOrDepartment(String name,String department);

    @Query("select e from Employee e where e.joiningDate=?1")
    List<Employee> findAllByJoiningDate(Date joiningDate);

}
