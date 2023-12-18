package com.example.libexpress.service;

import com.example.libexpress.entity.Category;
import com.example.libexpress.entity.Publisher;
import com.example.libexpress.entity.User;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.dto.UserDto;
import com.example.libexpress.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Page<Publisher> getAllPublishers(Integer page, Integer limit , String sortField, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return publisherRepository.findAll(pageRequest);
    }

    public Page<Publisher> findPaginated(Integer page, Integer limit, String sortField, String sortDirection, String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<Publisher> publisherPage;
        if(keyword != null) {
            publisherPage = publisherRepository.findAll(keyword,pageable);
        }else {
            publisherPage = publisherRepository.findAll(pageable);
        }

        List<Publisher> userDtoList = publisherPage.getContent();

        return new PageImpl<>(userDtoList, pageable, publisherPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public Publisher createPublisher(Publisher request) {
        Publisher publisher = new Publisher();
        publisher.setName(request.getName());
        publisherRepository.save(publisher);
        return publisher;
    }

    public Publisher updatePublisher(Integer id, Publisher request) {
        List<Publisher> publisherList = publisherRepository.findAll();
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy nhà xuất bản có id " + id));

        publisher.setName(request.getName());
        publisherRepository.save(publisher);
        return publisher;
    }

    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy nhà xuất bản có id " + id));
    }
}
