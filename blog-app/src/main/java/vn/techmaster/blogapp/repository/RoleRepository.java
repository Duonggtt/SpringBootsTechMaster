package vn.techmaster.blogapp.repository;

import vn.techmaster.blogapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.blogapp.model.dto.RoleDto;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);

//    List<RoleDto> findAllByIdIn(List<Integer> roleIds);

    List<Role> findAllByIdIn(List<Integer> roleIds);
}