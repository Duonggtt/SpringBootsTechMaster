package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.course.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findById(Integer id);

}
