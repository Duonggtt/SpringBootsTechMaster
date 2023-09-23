package com.example.productdemo.repository;

import com.example.productdemo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.name = ?1 order by p.count DESC")
    List<Product> getAllProductByNameAndOrderbyCount(String name);

    @Query("select p from Product p where lower(p.name) like concat('%' , LOWER(?1) , '%') ")
    Page<Product> getAllProductContainIgnocaseBySortingNameDesc(String name, Pageable pageable);

    @Query("select p from Product p order by p.price desc")
    List<Product> getAllProductBySortingPriceDesc();

    @Query("select p from Product p order by p.name")
    Page<Product> getAllProductSortbyNamePg(Pageable pageable);


    @Query("select p from Product p order by p.count")
    Page<Product> getAllProductByCount(Pageable pageable);

    @Query("select p from Product p where p.brand =?1 order by p.price ")
    Page<Product> getAllProductByBrandAndSortByPricePg(String brand, Pageable pageable);

    @Query("select count(p) from Product p where p.brand = ?1")
    long countProductQuantityByBrand(String brand);

    @Query("select count(p.count) from Product p where p.brand = ?1")
    long countByBrandGreaterThan(String brand);

}
