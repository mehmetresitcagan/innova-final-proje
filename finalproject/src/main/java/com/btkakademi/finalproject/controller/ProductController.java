package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> allProducts = service.getAllProducts();
        if (allProducts != null) {
            logger.info("Ürünler bulundu");
            return ResponseEntity.ok(allProducts);
        }
        logger.info("Ürünler bulunamadı.");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product productById = service.getProductById(productId);
        if (productById != null) {
            logger.info("Ürün bulundu");
            return ResponseEntity.ok(productById);
        }
        logger.info("Ürün bulunamadı.");
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public int addProduct(@RequestBody Product product) {
        logger.info("Ürün eklendi.");
        return service.addProduct(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        product.setProductId(productId);
        Product updateProduct = service.updateProduct(product, productId);
        if (updateProduct != null) {
            logger.info("Ürün güncellendi.");
            return ResponseEntity.ok(updateProduct);
        }
        logger.info("Ürün güncellenemedi.");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable int productId) {
        logger.info("Ürün silindi.");
        return service.deleteProduct(productId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductByName(@RequestParam String productName) {
        List<Product> searchProductByName = service.searchProductByName(productName);
        if (searchProductByName != null) {
            logger.info("Ürün bulundu.");
            return ResponseEntity.ok(searchProductByName);
        }
        logger.info("Ürün bulunamadı.");
        return ResponseEntity.notFound().build();
    }
}
