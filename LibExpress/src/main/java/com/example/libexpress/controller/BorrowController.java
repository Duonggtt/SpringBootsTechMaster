package com.example.libexpress.controller;

import com.example.libexpress.entity.*;
import com.example.libexpress.service.BorrowDetailService;
import com.example.libexpress.service.BorrowService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lib-express/admin/borrow-list")
public class BorrowController {

    private final BorrowService borrowService;

    private final BorrowDetailService borrowDetailService;

    public BorrowController(BorrowService borrowService, BorrowDetailService borrowDetailService) {
        this.borrowService = borrowService;
        this.borrowDetailService = borrowDetailService;
    }

    @GetMapping("")
    public String viewHomePage(Model model) {
        String keyword =null;
        return findPaginated(1, "id", "asc",keyword,model);
    }

    @GetMapping("/page/{page}")
    public String findPaginated(@PathVariable(value = "page") Integer page,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                Model model) {
        int limit = 10;
        Page<BorrowManagement> getBorrowPage = borrowService.findPaginated(page, limit, sortField, sortDirection,keyword);
        List<BorrowManagement> borrowList = getBorrowPage.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", getBorrowPage.getTotalPages());
        model.addAttribute("totalItems", getBorrowPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("pageData", getBorrowPage);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reverseSortDir",sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("borrowList", borrowList);
        model.addAttribute("keyword", keyword);
        return "admin/borrowManagement/borrow";
    }

    @GetMapping("/{id}/detail")
    public String getBorrowDetailPage(@PathVariable Integer id, Model model) {
        BorrowManagement borrow = borrowService.getBorrowTicketById(id);
        List<BorrowManagementDetail> borrowDetail = borrowDetailService.getBorrowDetailByBorrowId(borrow.getId());
        Librarian lib = borrow.getLibrarian();
        List<Book> bookList = new ArrayList<>();
        for (BorrowManagementDetail borrowManagementDetail : borrowDetail) {
            bookList.add(borrowManagementDetail.getBook());
        }
        model.addAttribute("lib",lib.getFullName());
        model.addAttribute("borrowDetailList",borrowDetail);
        model.addAttribute("bookList",bookList);
        model.addAttribute("borrow", borrow);
        return "admin/borrowManagement/borrow-detail";
    }
}
