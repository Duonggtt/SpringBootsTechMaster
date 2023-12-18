package com.example.libexpress.rest;

import com.example.libexpress.entity.Status;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/status")
public class StatusResource {

    @Autowired
    private StatusRepository statusRepository;
    @PutMapping
    public ResponseEntity<?> onOffStatus(Status st) {
        Status status = statusRepository.findById(1)
                .orElseThrow(() -> new NotFoundException("null"));

        status.setOpen(st.isOpen());
        statusRepository.save(status);
        return ResponseEntity.ok(status);
    }
}
