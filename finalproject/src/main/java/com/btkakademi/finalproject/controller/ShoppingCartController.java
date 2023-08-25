package com.btkakademi.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Belirtilen cartId'ye sahip alışveriş sepetini alır.
    @GetMapping("/{cartId}")
    public ShoppingCart getShoppingCartById(@PathVariable int cartId) {
        return shoppingCartService.getShoppingCartById(cartId);
    }

    /*
     * POST /api/shopping-carts/create
     * Açıklama: Yeni bir alışveriş sepeti oluşturur.
     */
    @PostMapping("")
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.createShoppingCart(shoppingCart);
    }
    // Belirtilen cartId'ye sahip alışveriş sepetini günceller.

    @PutMapping("/{cartId}")
    public ShoppingCart updateShoppingCart(@PathVariable int cartId, @RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.updateShoppingCart(cartId, shoppingCart);
    }
    // Belirtilen cartId'ye sahip alışveriş sepetini siler.

    @DeleteMapping("/{cartId}")
    public boolean deleteShoppingCart(@PathVariable int cartId) {
        boolean existsShoppingCartId = shoppingCartService.existsShoppingCartId(cartId);
        if (existsShoppingCartId) {
            shoppingCartService.deleteShoppingCart(cartId);
            return true;
        }
        return false;
    }

}
