package com.btkakademi.finalproject.service;

import java.util.List;

import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.dto.ProductDto;

public interface OrderService {
    int addOrder(OrderDto category);

    boolean deleteOrder(int orderId);

    OrderDto updateOrder(OrderDto category);

    boolean existsOrderById(int categoryId);

    List<OrderDto> searchOrderById(int orderId);

    List<OrderDto> getAllOrders();

    List<ProductDto> getAllProducts(int orderId);
}
