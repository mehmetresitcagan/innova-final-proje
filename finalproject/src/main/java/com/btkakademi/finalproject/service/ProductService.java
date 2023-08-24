package com.btkakademi.finalproject.service;

import com.btkakademi.finalproject.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int productId);

    int addProduct(Product product);

    Product updateProduct(Product product, int productId);

    boolean deleteProduct(int productId);

    List<Product> searchProductByName(String productName);

    boolean existsProductById(int productId);
}