package com.btkakademi.finalproject.model.dto;

import java.util.List;

public class ShoppingCartDto {

    private int shoppingCartId;
    private List<Integer> productAmount;
    private int userId;

    // Getter ve setter metotları buraya gelecek...

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
