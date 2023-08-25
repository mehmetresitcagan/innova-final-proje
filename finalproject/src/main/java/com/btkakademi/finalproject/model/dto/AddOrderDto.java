package com.btkakademi.finalproject.model.dto;

import java.util.List;

public class AddOrderDto {
    private int userId;
    private List<Integer> productIds;


    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public List<Integer> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

}
/*
    "productDto":{
"productId":1,
"productName":"kitap",
"price":10,
"description":"deneme",
"stock":10,
"category":"roman"

*/