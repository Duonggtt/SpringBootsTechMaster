package vn.techmaster.blogapp.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.blogapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);

    List<Role> findAllByIdIn(List<Integer> roleIds);
}