package com.btkakademi.finalproject.service;

import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(int productId);

    int addProduct(ProductDto productDto);

    ProductDto updateProduct(int productId, ProductDto productDto);

    boolean deleteProduct(int productId);

    List<ProductDto> searchProductByName(String productName);
}
