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

    @Autowired
    ProductService service;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> allProducts = service.getAllProducts();
        if (allProducts.size() > 0) {
            logger.info("Urun Listeleme Basarili");
            return ResponseEntity.ok(allProducts);
        }
        logger.info("Urun Listeleme Basarisiz");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product productById = service.getProductById(productId);
        if (productById != null) {
            logger.info("GetProductById Basarili");
            return ResponseEntity.ok(productById);
        }
        logger.info("GetProductById Basarisiz");
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public int addProduct(@RequestBody Product product) {
        return service.addProduct(product);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        Product updateProduct = service.updateProduct(product, productId);
        if (updateProduct != null) {
            product.setProductId(productId);
            logger.info("Urun Guncelleme :Basarili  ");
            return ResponseEntity.ok(updateProduct);
        }
        logger.info("Urun Guncelleme : Basarisiz");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        boolean deleteProduct = service.deleteProduct(productId);
        if (deleteProduct) {
            logger.info("Urun Silme: Basarili");
            return ResponseEntity.ok("Urun Silme Islemi Gerceklesti: " + productId);
        }
        logger.info("Urun Silme : Basarisiz");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductByName(@RequestParam String productName) {
        List<Product> searchProductByName = service.searchProductByName(productName);
        if (searchProductByName.size() > 0) {
            logger.info("Urun Listeleme Basarili");
            return ResponseEntity.ok(searchProductByName);
        }
        logger.info("Siparis Listeleme Basarisiz");
        return ResponseEntity.notFound().build();
    }
}
