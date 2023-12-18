package vn.techmaster.blogapp.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.blogapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}