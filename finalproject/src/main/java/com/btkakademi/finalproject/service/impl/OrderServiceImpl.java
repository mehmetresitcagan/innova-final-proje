package com.btkakademi.finalproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public int addOrder(OrderDto category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOrder'");
    }

    @Override
    public boolean deleteOrder(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrder'");
    }

    @Override
    public OrderDto updateOrder(OrderDto category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

    @Override
    public boolean existsOrderById(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsOrderById'");
    }

    @Override
    public List<OrderDto> searchOrderById(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchOrderById'");
    }

    @Override
    public List<OrderDto> getAllOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOrders'");
    }

    @Override
    public List<ProductDto> getAllProducts(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

}
