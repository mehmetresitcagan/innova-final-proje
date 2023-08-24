package com.btkakademi.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.entity.Order;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.repository.OrderRepository;
import com.btkakademi.finalproject.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Override
    public int addOrder(Order order) {
        repository.save(order);
        return order.getOrderId();
    }

    @Override
    public boolean deleteOrder(int orderId) {
        repository.deleteById(orderId);
        return true;
    }

    @Override
    public Order updateOrder(Order order, int orderId) {
        Order insider = repository.findByOrderId(orderId);
        if (repository.existsById(orderId)) {
            insider.setOrderId(order.getOrderId());
            return insider;
        }
        // throw atılacak (güncellenemedi gibi)
        return new Order();
    }

    @Override
    public boolean existsOrderById(int orderId) {
        return repository.existsById(orderId);
    }

    @Override
    public Order searchOrderByOrderId(int orderId) {

        return repository.findByOrderId(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public List<Product> getAllProducts(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

}
