package com.example.libexpress.service;

import com.example.libexpress.entity.BorrowManagement;
import com.example.libexpress.entity.BorrowManagementDetail;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.request.UpsertBorrowDetailRequest;
import com.example.libexpress.repository.BorrowDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowDetailService {

    @Autowired
    private BorrowDetailRepository borrowDetailRepository;


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

//    public BorrowManagementDetail createBorrowDetail(UpsertBorrowDetailRequest request) {
//
//    }
}
