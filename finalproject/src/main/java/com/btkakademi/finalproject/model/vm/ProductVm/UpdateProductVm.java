package com.btkakademi.finalproject.model.vm.ProductVm;

import java.util.List;

import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.model.entity.Order;
import com.btkakademi.finalproject.model.entity.ShoppingCart;

public class UpdateProductVm {
    private int productId;

    private String productName;

    private double price;

    private String description;

    private int stock;

    private Category category;

    private List<ShoppingCart> shoppingCarts;

    private List<Order> orders;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
