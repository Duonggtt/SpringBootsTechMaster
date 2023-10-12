package vn.techmaster.blogapp.repository;

import org.springframework.data.jpa.repository.Query;
import vn.techmaster.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.blogapp.model.dto.UserDto;
import vn.techmaster.blogapp.model.dto.UserInfo;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoles_NameIn(List<String> roles);
    @Query("""
        SELECT new vn.techmaster.blogapp.model.dto.UserDto(u.id, u.name, u.email, u.roles)
        FROM User u
    """)
    List<UserDto> getAllUserDto();

    <T> T findByEmail(String email, Class<T> type);

    @Query("""
        SELECT new vn.techmaster.blogapp.model.dto.UserDto(u.id, u.name, u.email, u.roles)
        FROM User u
    """)
    UserDto findByIdIn(Integer id);
}