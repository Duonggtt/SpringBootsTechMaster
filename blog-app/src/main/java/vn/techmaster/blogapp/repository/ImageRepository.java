package vn.techmaster.blogapp.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.blogapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findByUser_IdOrderByCreatedAtDesc(Integer id);
}