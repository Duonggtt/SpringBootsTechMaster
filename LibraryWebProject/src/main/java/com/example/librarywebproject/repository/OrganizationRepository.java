package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findByName(String name);
    List<Organization> findByUrlLink(String urlLink);
    Organization findById(int id);

    List<Organization> findAll();
}
