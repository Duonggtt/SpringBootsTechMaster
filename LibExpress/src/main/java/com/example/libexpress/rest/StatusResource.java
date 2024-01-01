package com.example.libexpress.rest;

import com.example.libexpress.entity.Status;
import com.example.libexpress.model.request.UpdateStatusRequest;
import com.example.libexpress.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/status")
public class StatusResource {

    private final StatusService statusService;

    public StatusResource(StatusService statusService) {
        this.statusService = statusService;
    }

    @PutMapping("/update")
    public ResponseEntity<?> onOffStatus(@Valid @RequestBody UpdateStatusRequest rq) {
        return ResponseEntity.ok(statusService.updateStatus(rq));
    }
}
