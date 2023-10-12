package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review , Integer> {
    List<Review> findByReviewerName(String reviewerName);
    List<Review> findByRating(float rating);
    List<Review> findAll();
}
