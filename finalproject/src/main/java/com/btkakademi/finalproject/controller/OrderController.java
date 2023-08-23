package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public int addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @DeleteMapping("/{orderId}")
    public boolean deleteOrder(@PathVariable int orderId) {
        return orderService.deleteOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public OrderDto updateOrder(@PathVariable int orderId, @RequestBody OrderDto orderDto) {
        orderDto.setOrderId(orderId);
        return orderService.updateOrder(orderDto);
    }

    @GetMapping("/{orderId}")
    public List<OrderDto> searchOrderById(@PathVariable int orderId) {
        return orderService.searchOrderById(orderId);
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}/products")
    public List<ProductDto> getAllProducts(@PathVariable int orderId) {
        return orderService.getAllProducts(orderId);
    }
}
