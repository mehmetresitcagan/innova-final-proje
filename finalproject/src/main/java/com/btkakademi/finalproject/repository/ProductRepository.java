package com.btkakademi.finalproject.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.btkakademi.finalproject.model.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductName(String productName);

    @Query(value = "select * from urunler", nativeQuery = true)
    List<Product> getAllProducts();

    Product findByProductId(int productId);

}