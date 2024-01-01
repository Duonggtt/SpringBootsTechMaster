package com.example.libexpress.repository;

import com.example.libexpress.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {



    @Query("SELECT DISTINCT bm FROM BorrowManagement bm "
            + "LEFT JOIN bm.user u "
            + "LEFT JOIN bm.librarian l "
            + "WHERE CONCAT(u.lastName, u.firstName, bm.status, l.fullName) LIKE %?1%")
    Page<History> findAll(String keyword, Pageable pageable);
}
