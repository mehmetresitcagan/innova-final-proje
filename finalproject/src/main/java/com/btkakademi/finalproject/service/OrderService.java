package com.btkakademi.finalproject.service;

import java.util.List;

import com.btkakademi.finalproject.model.entity.Order;
import com.btkakademi.finalproject.model.entity.Product;

public interface OrderService {
    int addOrder(Order order);

    boolean deleteOrder(int orderId);

    Order updateOrder(Order order, int orderId);

    boolean existsOrderById(int orderId);

    Order searchOrderByOrderId(int orderId);

    List<Order> getAllOrders();

    // siparişin içindeki tüm ürünleri getir.
    List<Product> getAllProducts(int orderId);
}
