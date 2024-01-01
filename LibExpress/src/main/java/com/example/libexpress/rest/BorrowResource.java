package com.example.libexpress.rest;

import com.example.libexpress.entity.BorrowManagementDetail;
import com.example.libexpress.model.request.UpsertBorrowDetailRequest;
import com.example.libexpress.model.request.UpsertBorrowRequest;
import com.example.libexpress.service.BorrowDetailService;
import com.example.libexpress.service.BorrowService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/borrow-list")
public class BorrowResource {

    private final BorrowService borrowService;
    private final BorrowDetailService borrowDetailService;

    public BorrowResource(BorrowService borrowService, BorrowDetailService borrowDetailService) {
        this.borrowService = borrowService;
        this.borrowDetailService = borrowDetailService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllBorrowTickets(@RequestParam(required = false, defaultValue = "id") String sortField,
                                        @RequestParam(required = false, defaultValue = "esc") String sortDirection,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return ResponseEntity.ok(borrowService.getAllBorrowTickets(page, limit , sortField, sortDirection));
    }

    @PostMapping
    public ResponseEntity<?> createBorrowTicket(@Valid @RequestBody UpsertBorrowRequest request) {
        return new ResponseEntity<>(borrowService.createBorrowTicket(request), HttpStatus.CREATED);
    }

//    @PostMapping("/detail/add")
//    public ResponseEntity<?> createBorrowDetail(@Valid @RequestBody UpsertBorrowDetailRequest request) {
//        return new ResponseEntity<>(borrowDetailService.createBorrowDetail(request), HttpStatus.CREATED);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateAuthor(@PathVariable Integer id,@Valid @RequestBody Author request) {
//        return new ResponseEntity<>(borrowService.updateAuthor(id,request), HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBorrowTicketById(@PathVariable Integer id) {
        return ResponseEntity.ok(borrowService.getBorrowTicketById(id));
    }

    @PostMapping("/add-detail")
    public ResponseEntity<?> createBorrowDetail(
            @RequestBody UpsertBorrowDetailRequest request) {

        return ResponseEntity.ok(borrowDetailService.createBorrowDetail(request));
    }


    @PutMapping("/{id}/detail")
    public ResponseEntity<?> updateBorrowDetail(@RequestBody UpsertBorrowDetailRequest request,@PathVariable Integer id) {
        return ResponseEntity.ok(borrowDetailService.updateBorrowDetail(request,id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBorrowDetail(@RequestParam("bookId") Integer bookId, @RequestParam("borrowId") Integer borrowId) {
        borrowDetailService.deleteDetail(bookId, borrowId);
        return ResponseEntity.ok("BorrowManagementDetail deleted successfully");
    }
}
