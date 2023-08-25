package com.btkakademi.finalproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.repository.ProductRepository;
import com.btkakademi.finalproject.service.ProductService;
import com.btkakademi.finalproject.util.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<ProductDto> getAllProducts() {
         List<Product> products = repository.findAll();
         List<ProductDto> productDtoList = ProductMapper.mapProductListToProductDtoList(products);
        return productDtoList;
    }

    @Override
    public Product getProductById(int productId) {
        Optional<Product> optionalProduct = repository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Searched product could not found. Bad request. Check your params");
        }
        return optionalProduct.get();
    }

    @Override
    public int addProduct(Product product) {
        repository.save(product);
        return product.getProductId();
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        Product tempProduct = getProductById(productId);
        if (repository.existsById(productId)) {
            tempProduct.setProductId(product.getProductId());
            tempProduct.setProductName(product.getProductName());
            return tempProduct;
        }
        // throw atılacak (güncellenemedi gibi)
        return new Product();
    }

    @Override
    public boolean deleteProduct(int productId) {
        if (existsProductById(productId)) {
            repository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        List<Product> products = repository.findByProductName(productName);
        return products;
    }

    @Override
    public boolean existsProductById(int productId) {
        return repository.existsById(productId);
    }

}