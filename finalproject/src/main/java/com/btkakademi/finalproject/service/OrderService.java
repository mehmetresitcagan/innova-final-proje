package com.btkakademi.finalproject.service;

import java.util.List;

import com.btkakademi.finalproject.model.dto.AddOrderDto;
import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.dto.ProductDto;

public interface OrderService {
    int addOrder(AddOrderDto orderDto);

    boolean deleteOrder(int orderId);

    OrderDto updateOrder(OrderDto orderDto, int orderId);

    boolean existsOrderById(int orderId);

    OrderDto searchOrderByOrderId(int orderId);

    List<OrderDto> getAllOrders();

    // Siparişin içindeki tüm ürünleri getir.
    List<ProductDto> getAllProducts(int orderId);
}