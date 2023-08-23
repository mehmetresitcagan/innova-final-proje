package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public int addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable int productId, @RequestBody ProductDto productDto) {
        productDto.setProductId(productId);
        return productService.updateProduct(productId, productDto);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProductByName(@RequestParam String productName) {
        return productService.searchProductByName(productName);
    }
}
