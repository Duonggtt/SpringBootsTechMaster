package com.example.libexpress.service;

import com.example.libexpress.entity.Status;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.request.UpdateStatusRequest;
import com.example.libexpress.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;
    public Status updateStatus(UpdateStatusRequest rq) {
        Status status = statusRepository.findById(1)
                .orElseThrow(() -> new NotFoundException("loi"));
        status.setStatus(rq.isStatus());
        System.out.println(rq.isStatus());
        statusRepository.save(status);
        return status;
    }
}
