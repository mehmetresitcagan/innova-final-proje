package com.btkakademi.finalproject.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.entity.ShoppingCart;
import com.btkakademi.finalproject.repository.ShoppingCartRepository;
import com.btkakademi.finalproject.service.ShoppingCartService;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart getShoppingCartById(int cartId) {
        Optional<ShoppingCart> sOptional = shoppingCartRepository.findAll(cartId);
        return sOptional.orElseThrow();

    }

    @Override
    public ShoppingCart updateShoppingCart(int cartId, ShoppingCart shoppingCart) {
        if (shoppingCartRepository.existsById(cartId)) {
            shoppingCart.setShoppingCartId(cartId);
            return shoppingCartRepository.save(shoppingCart);
        }
        return null;

    }

    @Override
    public boolean deleteShoppingCart(int cartId) {
        shoppingCartRepository.deleteById(cartId);
        return true;
    }

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public boolean existsShoppingCartId(int cartId) {
        return shoppingCartRepository.existsById(cartId);
  
    }

}
