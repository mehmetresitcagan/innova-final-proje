package com.btkakademi.finalproject.model.vm.ShoppingCartVm;

import java.util.List;

import com.btkakademi.finalproject.model.entity.User;

public class UpdateShoppingCartVm {
    private int shoppingCartId;
    private List<Integer> productAmount;
    private User user;

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

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

}
