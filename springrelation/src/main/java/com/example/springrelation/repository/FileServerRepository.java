package com.example.springrelation.repository;

import com.example.springrelation.entity.FileServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileServerRepository extends JpaRepository<FileServer, Integer> {
    List<FileServer> findByUser_id(Integer id);
}