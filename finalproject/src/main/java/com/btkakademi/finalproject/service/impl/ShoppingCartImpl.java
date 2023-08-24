package com.btkakademi.finalproject.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.entity.ShoppingCart;
import com.btkakademi.finalproject.repository.ShoppingCartRepository;
import com.btkakademi.finalproject.service.ShoppingCartService;

//import jakarta.validation.ReportAsSingleViolation;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;

    @Override
    public ShoppingCart getShoppingCartById(int cartId) {
        Optional<ShoppingCart> sOptional = repository.findAll(cartId);
        return sOptional.orElseThrow();

    }

    @Override
    public ShoppingCart updateShoppingCart(int cartId, ShoppingCart shoppingCart) {
        if (repository.existsById(cartId)) {
            shoppingCart.setShoppingCartId(cartId);
            return repository.save(shoppingCart);
        }
        return null;

    }

    @Override
    public boolean deleteShoppingCart(int cartId) {
        repository.deleteById(cartId);
        return true;
    }

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return repository.save(shoppingCart);
    }

    @Override
    public boolean existsShoppingCartId(int cartId) {
        return repository.existsById(cartId);

    }

    /*
     * @Override
     * public double calculateTotalPrice(List<Product> products) {
     * double totalPrice = 0.0;
     * for (Product product : products) {
     * totalPrice += product.getPrice();
     * }
     * return totalPrice;
     * }
     * 
     * @Override
     * public void addProductToShoppingCart(Product product, int cartId) {
     * if(repository.existsById(cartId)){
     * 
     * }
     * }
     * 
     * @Override
     * public void deleteProductFromShoppingCart(Product product, int cartId) {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'deleteProductFromShoppingCart'"
     * );
     * }
     * 
     * @Override
     * public void updateShoppingCart(ShoppingCart cart, int cartId) {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'updateShoppingCart'");
     * }
     * 
     * @Override
     * public void cleanShoppingCart(int cartId) {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'cleanShoppingCart'");
     * }
     * 
     * @Override
     * public Order confirmShoppingCart(int cartId) {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'confirmShoppingCart'");
     * }
     */

}
