package com.btkakademi.finalproject.service;

import com.btkakademi.finalproject.model.entity.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart getShoppingCartById(int cartId);

    ShoppingCart updateShoppingCart(int cartId, ShoppingCart shoppingCart);

    boolean deleteShoppingCart(int cartId);

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);

    boolean existsShoppingCartId(int cartId);

    /*
     * double calculateTotalPrice(List<Product> products);
     * 
     * void addProductToShoppingCart(Product product, int cartId);
     * 
     * void deleteProductFromShoppingCart(Product product, int cartId);
     * 
     * void updateShoppingCart(ShoppingCart cart, int cartId);
     * 
     * void cleanShoppingCart(int cartId);
     * 
     * Order confirmShoppingCart(int cartId);
     */

}
