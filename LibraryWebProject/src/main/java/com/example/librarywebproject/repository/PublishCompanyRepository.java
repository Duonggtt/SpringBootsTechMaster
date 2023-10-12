package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.PublishCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishCompanyRepository extends JpaRepository<PublishCompany, Integer> {
    List<PublishCompany> findByName(String name);
    List<PublishCompany> findByAddress(String address);
    List<PublishCompany> findAll();
}
