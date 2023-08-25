package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.exception.category.CategoryNotFoundException;
import com.btkakademi.finalproject.model.dto.AddOrderDto;
import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.entity.Order;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.service.OrderService;
import com.btkakademi.finalproject.util.mapper.CategoryMapper;
import com.btkakademi.finalproject.util.mapper.OrderMapper;
import com.btkakademi.finalproject.util.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping(value = "") // başarılı
    public ResponseEntity<String> addOrder(@RequestBody AddOrderDto orderDto) {
        service.addOrder(orderDto);
        return ResponseEntity.ok("Order ekleme başarılı");
    }

    // YAPILACAK
    @PutMapping("/{orderId}") // user dönmüyor
    public ResponseEntity<OrderDto> updateOrder(@PathVariable int orderId, @RequestBody OrderDto orderDto) {
        OrderDto order = service.updateOrder(orderDto, orderId);
        return ResponseEntity.ok(order);
    }


    @DeleteMapping("/{orderId}")// silme başarlı
    public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
        boolean deleteOrder = service.deleteOrder(orderId);
        if (deleteOrder) {
            service.deleteOrder(orderId);
            return ResponseEntity.ok("Sipariş Silindi");
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{orderId}") // order_ıd dönüyor user boş
    public ResponseEntity<OrderDto> searchOrderByOrderId(@PathVariable int orderId) {
        OrderDto orderDto = service.searchOrderByOrderId(orderId);
        return ResponseEntity.ok(orderDto);
    }
    @GetMapping(value = "") // sadece orderId
    public List<OrderDto> getAllOrders() {
        List<OrderDto> allOrders = service.getAllOrders();
        return allOrders;
    }

    @GetMapping("/products/{orderId}")// bu çalışmıyor
    public List<Product> getAllProducts(@PathVariable int orderId) {
        List<Product> products = ProductMapper.mapProductDtoListToProductList(service.getAllProducts(orderId));
        return products;
    }
}
