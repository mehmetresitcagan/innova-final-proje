package com.btkakademi.finalproject.service;

import com.btkakademi.finalproject.model.entity.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart getShoppingCartById(int cartId);

    ShoppingCart updateShoppingCart(int cartId, ShoppingCart shoppingCart);

    boolean deleteShoppingCart(int cartId);

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);

    boolean existsShoppingCartId(int cartId);

}
