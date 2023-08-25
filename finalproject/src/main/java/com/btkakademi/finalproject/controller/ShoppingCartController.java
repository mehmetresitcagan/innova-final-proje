package com.btkakademi.finalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btkakademi.finalproject.model.entity.ShoppingCart;
import com.btkakademi.finalproject.service.ShoppingCartService;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    // Belirtilen cartId'ye sahip alışveriş sepetini alır.
    @GetMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable int cartId) {
        ShoppingCart shoppingCartById = shoppingCartService.getShoppingCartById(cartId);
        if (shoppingCartById != null) {
            logger.info("Alışveriş sepeti bulundu.");
            return ResponseEntity.ok(shoppingCartById);
        }
        logger.info("Alışveriş sepeti Bulunamadi");
        return ResponseEntity.notFound().build();
    }

    /*
     * POST /api/shopping-carts/create
     * Açıklama: Yeni bir alışveriş sepeti oluşturur.
     */
    @PostMapping("")
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        ShoppingCart createCart = shoppingCartService.createShoppingCart(shoppingCart);
        if (createCart != null) {
            logger.info("Alışveriş sepeti başarıyla oluşturuldu.");
            return ResponseEntity.ok(createCart);
        }
        logger.info("Alışveriş sepeti Bulunamadi");
        return ResponseEntity.notFound().build();
    }
    // Belirtilen cartId'ye sahip alışveriş sepetini günceller.

    @PutMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable int cartId,
            @RequestBody ShoppingCart shoppingCart) {
        ShoppingCart updateCart = shoppingCartService.updateShoppingCart(cartId, shoppingCart);
        if (updateCart != null) {
            logger.info("Alışveriş sepeti başarıyla güncellendi.");
            return ResponseEntity.ok(updateCart);
        }
        logger.info("Alışveriş sepeti Bulunamadi");
        return ResponseEntity.notFound().build();
    }
    // Belirtilen cartId'ye sahip alışveriş sepetini siler.

    @DeleteMapping("/{cartId}")
    public Object deleteShoppingCart(@PathVariable int cartId) {
        boolean existsShoppingCartId = shoppingCartService.existsShoppingCartId(cartId);
        if (existsShoppingCartId) {
            logger.info("Alışveriş sepeti silindi.");
            shoppingCartService.deleteShoppingCart(cartId);
            return ResponseEntity.ok(true);
        }
        logger.info("Alışveriş sepeti Bulunamadi");
        return ResponseEntity.notFound().build();
    }

}
