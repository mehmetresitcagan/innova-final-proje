package com.btkakademi.finalproject.service;

import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    Product getProductByProductId(int productId);

    int addProduct(Product product);

    Product updateProduct(Product product, int productId);

    boolean deleteProduct(int productId);

    List<Product> searchProductByProductName(String productName);

    boolean existsProductById(int productId);
}