package com.example.productdemo;

import com.example.productdemo.entity.Product;
import com.example.productdemo.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ProductDemoApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void saveAllStudent() {
        Faker faker = new Faker();
        for(int i = 0;i< 100;i++) {
            Product product = new Product(
                    null,
                    faker.name().fullName(),
                    faker.number().numberBetween(1000,90000),
                    faker.name().title(),
                    faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    faker.number().numberBetween(1,90));

            productRepository.save(product);
        }
    }

    @Test
    void getProductByQuery() {
        long products = productRepository.countByBrandGreaterThan("Future Interactions Coordinator");
        System.out.println(products);
    }

}
