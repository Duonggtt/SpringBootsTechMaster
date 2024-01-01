package com.example.libexpress.service;

import com.example.libexpress.entity.*;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.request.UpsertBorrowRequest;
import com.example.libexpress.repository.BorrowRepository;
import com.example.libexpress.repository.LibrarianRepository;
import com.example.libexpress.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LibrarianRepository librarianRepository;

    public Page<BorrowManagement> getAllBorrowTickets(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return borrowRepository.findAll(pageRequest);
    }

    public Page<BorrowManagement> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<BorrowManagement> borrowPage;
        if(keyword != null) {
            borrowPage = borrowRepository.findAll(keyword,pageable);
        }else {
            borrowPage = borrowRepository.findAll(pageable);
        }

        List<BorrowManagement> borrowList = borrowPage.getContent();

        return new PageImpl<>(borrowList, pageable, borrowPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public BorrowManagement createBorrowTicket(UpsertBorrowRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("Khong tim thay user vs id = " + request.getUserId()));
        Librarian librarian = librarianRepository.findById(1)
                .orElseThrow(() -> new NotFoundException("null") );


        BorrowManagement borrowManagement = new BorrowManagement();
        borrowManagement.setUser(user);
        borrowManagement.setUsername(user.getFirstName() + ' ' + user.getLastName());
        borrowManagement.setBorrowDate(new Date());
        borrowManagement.setBorrowDateQuantity(request.getBorrowDateQuantity());
        borrowManagement.setBookQuantity(request.getBook_quantity());
        borrowManagement.setStatus("Đang mượn");
        borrowManagement.setLibrarian(librarian);
        return borrowManagement;
    }

    public BorrowManagement updateBorrowTicket(UpsertBorrowRequest request , Integer id) {
        BorrowManagement borrowManagement = borrowRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay phieu muon co id= " + id));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("Khong tim thay user vs id = " + request.getUserId()));
        Librarian librarian = librarianRepository.findById(1)
                .orElseThrow(() -> new NotFoundException("null") );

        borrowManagement.setUser(user);
        borrowManagement.setUsername(user.getFirstName() + ' ' + user.getLastName());
        borrowManagement.setBorrowDate(new Date());
        borrowManagement.setBorrowDateQuantity(request.getBorrowDateQuantity());
        borrowManagement.setBookQuantity(request.getBook_quantity());
        borrowManagement.setStatus(request.toString());
        borrowManagement.setLibrarian(librarian);

        if(request.getStatus().equals("Đã trả")) {
            History his = new History();

        }
        return borrowManagement;
    }

    public BorrowManagement getBorrowTicketById(Integer id) {
        return borrowRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay phieu muon co id = " + id));
    }
}
