package com.example.libexpress.service;

import com.example.libexpress.entity.BorrowManagement;
import com.example.libexpress.entity.Category;
import com.example.libexpress.entity.History;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.repository.BorrowRepository;
import com.example.libexpress.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    public Page<History> getAllHistories(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return historyRepository.findAll(pageRequest);
    }

    public Page<History> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<History> historyPage;
        if(keyword != null) {
            historyPage = historyRepository.findAll(keyword,pageable);
        }else {
            historyPage = historyRepository.findAll(pageable);
        }

        List<History> histories = historyPage.getContent();

        return new PageImpl<>(histories, pageable, historyPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }



    public History getHistoryById(Integer id) {
        return historyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay lich su muon voi id =" + id));

    }
}
