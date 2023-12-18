package com.example.libexpress.repository;

import com.example.libexpress.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findById(Integer id);
    Optional<Author> findByBirthDate(Data birthdate);
    Optional<Author> findByName(String name);
    @Query("select  a from Author a where "
            + "concat(a.id, a.name)"
            + "LIKE %?1%")
    Page<Author> findAll(String keyword, Pageable pageable);

}
