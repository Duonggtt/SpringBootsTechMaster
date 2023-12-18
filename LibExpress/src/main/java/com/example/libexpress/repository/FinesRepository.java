package com.example.libexpress.repository;

import com.example.libexpress.entity.Fines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinesRepository extends JpaRepository<Fines, Integer> {
}
