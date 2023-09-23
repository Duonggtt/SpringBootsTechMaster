package com.example.productdemo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    @Transactional
    public void testTrasaction();
}
