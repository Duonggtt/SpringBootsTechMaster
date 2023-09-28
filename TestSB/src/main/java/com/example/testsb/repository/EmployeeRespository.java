package com.example.testsb.repository;

import com.example.testsb.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

    //Tìm tất cả các Employee theo emailAddress và lastName
    List<Employee> findAllByEmailAddressAndLastName(String emailAddress, String lastName);

    //Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
    List<Employee> findDistinctByFirstNameOrLastName(String firstName, String lastName);

    //Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
    List<Employee> findAllByLastNameOrderByFirstNameAsc(String lastName);

    //Tìm tất cả các Employee theo fistName không phân biệt hoa thường
    List<Employee> findAllByFirstNameIgnoreCase(String firstName);

    // Tìm tất cả Employee, sắp xếp theo firstName tăng dần và thực hiện phân trang
    Page<Employee> findAllByOrderByFirstNameAsc(Pageable pageable);

}
