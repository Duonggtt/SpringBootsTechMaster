package com.example.testsb.Service;

import com.example.testsb.entity.Employee;
import com.example.testsb.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRespository employeeRepository;


    public Page<Employee> findAllEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAllByOrderByFirstNameAsc(pageable);
    }
}
