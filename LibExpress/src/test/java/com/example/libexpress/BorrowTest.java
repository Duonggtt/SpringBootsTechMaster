package com.example.libexpress;

import com.example.libexpress.entity.*;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class BorrowTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowDetailRepository borrowDetailRepository;
    @Test
    public void save_borrow() {

        BorrowManagement br = new BorrowManagement();
        User user = userRepository.findById(9)
                .orElseThrow();
        Librarian librarian = librarianRepository.findById(1)
                .orElseThrow();
        br.setUser(user);
        br.setUsername(user.getFirstName() + ' ' + user.getLastName());
        br.setBorrowDate(new Date());
        br.setBorrowDateQuantity(5);

        // Chuyển đổi Date sang Instant
        Instant instant = new Date().toInstant();

        // Chuyển đổi Instant sang LocalDate
        LocalDate localDateNow = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        // Tăng ngày
        LocalDate returnDate = localDateNow.plusDays(br.getBorrowDateQuantity());

        // Kiểm tra xem có phải là cuối tháng không
        if (localDateNow.getMonth() != returnDate.getMonth()) {
            // Nếu không, điều chỉnh để là cuối tháng
            returnDate = localDateNow.withDayOfMonth(localDateNow.lengthOfMonth());
        }

        // Kiểm tra xem có phải là cuối năm không
        if (localDateNow.getYear() != returnDate.getYear()) {
            // Nếu không, điều chỉnh để là cuối năm
            returnDate = localDateNow.withDayOfYear(localDateNow.lengthOfYear());
        }

        // Chuyển đổi LocalDate sang Instant
        Instant returnDateres = returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        // Chuyển đổi Instant sang Date
        Date res = Date.from(returnDateres);
        br.setReturnDate(res);

        br.setBookQuantity(2);
        br.setStatus("Còn mới");
        br.setLibrarian(librarian);
        borrowRepository.save(br);

    }

    @Test
    public void save_borrow_detail() {
        BorrowManagement br = borrowRepository.findById(3)
                .orElseThrow(() -> new NotFoundException("null"));
        int j = 4;
        for(int i =0;i<br.getBookQuantity();i++) {

            Book book = bookRepository.findById(j)
                    .orElseThrow(() -> new NotFoundException("null"));
            j++;
            BorrowManagementDetail brDetail = new BorrowManagementDetail();
            brDetail.setBorrowManagement(br);
            brDetail.setBook(book);
            brDetail.setBookTitle(book.getTitle());
            brDetail.setBookAuthor(book.getAuthor().getName());
            brDetail.setBookStatus("Còn mới");
            brDetail.setAmount(br.getBorrowDateQuantity() * 1000);
            brDetail.setBorrowManagement(br);
            borrowDetailRepository.save(brDetail);
        }

    }

    @Test
    void te() {
        System.out.println(borrowDetailRepository.findAllById(13).size());
        for(int i =0;i<borrowDetailRepository.findAllById(13).size();i++) {

            System.out.println(borrowDetailRepository.findAllById(13).get(i).getBookTitle());
        }
    }
}
