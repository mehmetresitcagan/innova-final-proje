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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService service;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(value = "") // başarılı
    public ResponseEntity<String> addOrder(@RequestBody AddOrderDto orderDto) {
        if (orderDto != null) {
            service.addOrder(orderDto);
            logger.info("Siparis Ekleme Basarili");
            return ResponseEntity.ok("Siparis Basariyla Eklendi" + orderDto.getUserId());
        }
        logger.info("Siparis Ekleme Basarisiz");
        return ResponseEntity.notFound().build();
    }

    // YAPILACAK
    @PutMapping("/{orderId}") // user dönmüyor
    public ResponseEntity<OrderDto> updateOrder(@PathVariable int orderId, @RequestBody OrderDto orderDto) {
        OrderDto order = service.updateOrder(orderDto, orderId);
        if (order != null) {
            logger.info("Siparis Guncelleme Basarili");
            return ResponseEntity.ok(order);
        }
        logger.info("Siparis Guncelleme Basarili");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{orderId}") // silme başarlı
    public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
        boolean deleteOrder = service.deleteOrder(orderId);
        if (deleteOrder) {
            logger.info("Siparis Silme Basarili");
            service.deleteOrder(orderId);
            return ResponseEntity.ok(orderId + " Numaralı Siparisiniz Silinmistir");
        }
        logger.info("Siparis Silme Basarisiz");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{orderId}") // order_ıd dönüyor user boş
    public ResponseEntity<OrderDto> searchOrderByOrderId(@PathVariable int orderId) {
        OrderDto orderDto = service.searchOrderByOrderId(orderId);
        if (orderDto != null) {
            logger.info("Siparis Listelendi");
            return ResponseEntity.ok(orderDto);
        }
        logger.info("Siparis Listeleme Basarisiz");
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "") // sadece orderId
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> allOrders = service.getAllOrders();
        if (allOrders != null) {
            logger.info("Siparisler Listelendi");
            return ResponseEntity.ok(allOrders);
        }
        logger.info("Siparisler Listeleme Basarisiz");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/products/{orderId}") // bu çalışmıyor
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable int orderId) {
        List<Product> products = ProductMapper.mapProductDtoListToProductList(service.getAllProducts(orderId));
        if (products.size()>0) {
            logger.info("Siparis Listeleme Basarili");
            return ResponseEntity.ok(products);
        }
        logger.info("Siparis Listeleme Basarisiz");
        return ResponseEntity.notFound().build();
    }
}
