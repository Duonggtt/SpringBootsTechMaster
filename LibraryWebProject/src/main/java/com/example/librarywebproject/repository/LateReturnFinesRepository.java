package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.BorrowManagement;
import com.example.librarywebproject.entity.LateReturnFines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LateReturnFinesRepository extends JpaRepository<LateReturnFines, Integer> {
    List<LateReturnFines> findByPunishAt(Date punishAt);
    List<LateReturnFines> findByReason(String reason);
    List<LateReturnFines> findByBorrowManagement(BorrowManagement borrowManagement);

    Optional<LateReturnFines> findById(Integer id);
}
