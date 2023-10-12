package com.example.librarywebproject.repository;

import com.example.librarywebproject.entity.BorrowManagement;
import com.example.librarywebproject.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BorrowManagementRepository extends JpaRepository<BorrowManagement, Integer> {
    List<BorrowManagement> findByLibrarian(Librarian librarian);
    List<BorrowManagement> findByReturnAt(Date returnAt);
    List<BorrowManagement> findByDueAt(Date dueAt);
    List<BorrowManagement> findByBorrowAt(Date borrowAt);
}
