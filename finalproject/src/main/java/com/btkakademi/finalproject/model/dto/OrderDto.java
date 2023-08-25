package com.btkakademi.finalproject.model.dto;

public class OrderDto {

    private int orderId;
    private UserDto user;
    private ProductDto productDto;
    // Other properties like products, totalAmount, etc.

    // Getters and setters

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    // Other getters and setters for additional properties
}
