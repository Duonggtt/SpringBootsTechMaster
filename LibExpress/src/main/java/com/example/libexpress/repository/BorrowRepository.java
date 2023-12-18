package com.example.libexpress.repository;

import com.example.libexpress.entity.BorrowManagement;
import com.example.libexpress.entity.BorrowManagementDetail;
import com.example.libexpress.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowManagement, Integer> {

    @Query("SELECT DISTINCT bm FROM BorrowManagement bm "
            + "LEFT JOIN bm.user u "
            + "LEFT JOIN bm.librarian l "
            + "WHERE CONCAT(u.lastName, u.firstName, bm.status, l.fullName) LIKE %?1%")
    Page<BorrowManagement> findAll(String keyword, Pageable pageable);

    List<BorrowManagementDetail> findByIdIn(List<Integer> borrowDetailsId);
}
