package com.example.libexpress.repository;

import com.example.libexpress.entity.BorrowManagement;
import com.example.libexpress.entity.BorrowManagementDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowDetailRepository extends JpaRepository<BorrowManagementDetail, Integer> {

    @Query("SELECT DISTINCT bd FROM BorrowManagementDetail bd "
            + "LEFT JOIN bd.book b "
            + "LEFT JOIN b.categories c "
            + "WHERE CONCAT( b.title,b.author.name, c.name) LIKE %?1%")
    Page<BorrowManagementDetail> findAll(String keyword, Pageable pageable);

    List<BorrowManagementDetail> findAllById(Integer id);


    List<BorrowManagementDetail> findAllByBorrowManagementId(Integer id);
}
