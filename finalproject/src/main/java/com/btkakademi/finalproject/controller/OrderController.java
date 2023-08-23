package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.entity.Order;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping(value = "")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        service.addOrder(order);
        return ResponseEntity.ok("Order ekleme başarılı");
    }

    // YAPILACAK
    @PutMapping("/{orderId}")
    public Order updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        order.setOrderId(orderId);
        return service.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public boolean deleteOrder(@PathVariable int orderId) {
        boolean existsOrderById = service.existsOrderById(orderId);
        if (existsOrderById) {
            service.deleteOrder(orderId);
            return true;
        }
        return false;
    }

    @GetMapping("/{orderId}")
    public Order searchOrderByOrderId(@PathVariable int orderId) {
        return service.searchOrderByOrderId(orderId);
    }

    @GetMapping(value = "")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{orderId}/products")
    public List<Product> getAllProducts(@PathVariable int orderId) {
        return service.getAllProducts(orderId);
    }
}
