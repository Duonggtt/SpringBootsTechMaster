package com.example.libexpress.service;

import com.example.libexpress.entity.*;
import com.example.libexpress.exception.DuplicateException;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.request.UpsertBorrowDetailRequest;
import com.example.libexpress.model.request.UpsertBorrowRequest;
import com.example.libexpress.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowDetailService {

    @Autowired
    private BorrowDetailRepository borrowDetailRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private FinesRepository finesRepository;

    public Page<BorrowManagementDetail> getAllBorrowDetails(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return borrowDetailRepository.findAll(pageRequest);
    }

    public Page<BorrowManagementDetail> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<BorrowManagementDetail> borrowDetailPage;
        if(keyword != null) {
            borrowDetailPage = borrowDetailRepository.findAll(keyword,pageable);
        }else {
            borrowDetailPage = borrowDetailRepository.findAll(pageable);
        }

        List<BorrowManagementDetail> borrowList = borrowDetailPage.getContent();

        return new PageImpl<>(borrowList, pageable, borrowDetailPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public List<BorrowManagementDetail> getBorrowDetailByBorrowId(Integer id) {
        return borrowDetailRepository.findAllByBorrowManagementId(id);
    }


    public BorrowManagementDetail createBorrowDetail(UpsertBorrowDetailRequest request) {
        
        BorrowManagementDetail brDetail = new BorrowManagementDetail();
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new NotFoundException("Khong tim thay sach"));
        BorrowManagement borrowManagement = borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new NotFoundException("Ko tim thay thong tin phieu muon"));

        brDetail.setBorrowManagement(borrowManagement);
        brDetail.setBook(book);
        brDetail.setBookTitle(book.getTitle());
        brDetail.setBookAuthor(book.getAuthor().getName());
        brDetail.setBookStatus("Còn mới");
        borrowDetailRepository.save(brDetail);
        return brDetail;
    }

    public BorrowManagementDetail updateBorrowDetail(UpsertBorrowDetailRequest request, Integer id) {
        BorrowManagementDetail brDetail = borrowDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay thong tin chi tiết phieu muon"));
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new NotFoundException("Khong tim thay sach"));
        BorrowManagement borrowManagement = borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new NotFoundException("Ko tim thay thong tin phieu muon"));

        brDetail.setBorrowManagement(borrowManagement);
        brDetail.setBook(book);
        brDetail.setBookTitle(book.getTitle());
        brDetail.setBookAuthor(book.getAuthor().getName());
        brDetail.setBookStatus(request.getBookStatus());
        borrowDetailRepository.save(brDetail);

        return brDetail;
    }

    public void deleteDetail(Integer id, Integer borrowId) {
       BorrowManagementDetail result = borrowDetailRepository.findByBookIdAndBorrowManagementId(id, borrowId);
        borrowDetailRepository.delete(result);
    }
}
