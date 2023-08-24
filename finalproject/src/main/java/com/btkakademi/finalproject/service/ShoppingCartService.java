package com.btkakademi.finalproject.service;


public interface ShoppingCartService {

    ShoppingCart getShoppingCartById(int cartId);

    ShoppingCart updateShoppingCart(int cartId, ShoppingCart shoppingCart);

    boolean deleteShoppingCart(int cartId);

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);

    boolean existsShoppingCartId(int cartId);

}
