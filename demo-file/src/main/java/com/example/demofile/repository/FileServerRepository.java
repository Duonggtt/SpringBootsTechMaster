package com.example.demofile.repository;

import com.example.demofile.model.entity.FileServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileServerRepository extends JpaRepository<FileServer, Integer> {
    List<FileServer> findByUser_IdOrderByCreatedAtDesc(Integer id);
}
