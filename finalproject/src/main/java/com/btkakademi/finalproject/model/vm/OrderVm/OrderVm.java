package com.btkakademi.finalproject.model.vm.OrderVm;

public class OrderVm {

    private int orderId;
    private int userId;
    // Other properties like products, totalAmount, etc.

    // Getters and setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
