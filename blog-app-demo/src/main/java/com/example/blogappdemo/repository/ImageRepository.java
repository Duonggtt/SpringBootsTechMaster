package com.example.blogappdemo.repository;

import com.example.blogappdemo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
