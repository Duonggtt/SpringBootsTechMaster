package com.example.librarywebproject.service;

import com.example.librarywebproject.entity.Card;
import com.example.librarywebproject.entity.Reader;
import com.example.librarywebproject.model.request.UpsertReaderRequest;
import com.example.librarywebproject.repository.CardRepository;
import com.example.librarywebproject.repository.ReaderRepository;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private CardRepository cardRepository;



    public Reader createReader(UpsertReaderRequest request) {
        Slugify slugify = Slugify.builder().build();
        Reader reader = Reader.builder()
                .fullName(request.getFullName())
                .address(request.getAddress())
                .birth(request.getBirth())
                .username(request.getUsername())
                .password(request.getPassword())
                .avatar(request.getAvatar())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        return null;
    }



}
