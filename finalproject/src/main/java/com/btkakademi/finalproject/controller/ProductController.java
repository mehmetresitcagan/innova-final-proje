package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return service.getProductById(productId);
    }

    @PostMapping
    public int addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        product.setProductId(productId);
        return service.updateProduct(product, productId);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable int productId) {
        return service.deleteProduct(productId);
    }

    @GetMapping("/search")
    public List<Product> searchProductByName(@RequestParam String productName) {
        return service.searchProductByName(productName);
    }
}
