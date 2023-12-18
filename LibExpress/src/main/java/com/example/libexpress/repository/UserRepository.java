package com.example.libexpress.repository;

import com.example.libexpress.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findById(Integer id);
    Optional<User> findByEmail(String email);
    Optional<User> findByFullName(String fullname);
    @Query("select u from User u order by u.fullName ASC ")
    List<User> getAllUserOrderByFullNameASC();

    @Query("select u from User u order by u.fullName DESC")
    List<User> getAllUserOrderByFullNameDESC();
    List<User> findAllByAddress(String address);

    Page<User> findAllByOrderByIdDesc(Pageable pageable);

    Page<User> findAllByOrderByIdAsc(Pageable pageable);
    List<User> findAllByOrderByIdAsc();
    Page<User> findByStatus(Boolean status, Pageable pageable);
    @Query("SELECT u FROM User u ORDER BY SUBSTRING_INDEX(u.fullName, ' ', -1) ASC, u.fullName ASC")
    Page<User> findAllOrderByNameAsc(Pageable pageable);

    @Query("SELECT u FROM User u ORDER BY SUBSTRING_INDEX(u.fullName, ' ', -1) DESC, u.fullName DESC")
    Page<User> findAllOrderByNameDesc(Pageable pageable);

//    Page<User> findByNameContainingIgnoreCase(String name,Pageable pageable);

    @Query("select  u from User  u where "
            + "concat(u.id, u.lastName, u.firstName)"
            + "LIKE %?1%")
    Page<User> findAll(String keyword, Pageable pageable);
}
