package com.example.productdemo.service.impl;

import com.example.productdemo.repository.ProductRepository;
import com.example.productdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void testTrasaction() {

    }
}
