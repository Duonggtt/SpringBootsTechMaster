package com.example.libexpress.repository;

import com.example.libexpress.entity.FinesLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinesLevelRepository extends JpaRepository<FinesLevel, Integer> {
}
