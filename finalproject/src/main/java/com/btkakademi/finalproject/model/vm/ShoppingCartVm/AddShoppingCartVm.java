package com.btkakademi.finalproject.model.vm.ShoppingCartVm;

import java.util.List;

import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.model.entity.User;

public class AddShoppingCartVm {

    private List<Integer> productAmount;

    private User user;

    private List<Product> products;

    public List<Integer> getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(List<Integer> productAmount) {
        this.productAmount = productAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
