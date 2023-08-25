package com.btkakademi.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from siparisler", nativeQuery = true)
    List<Order> getAllOrders();

    //Order findByOrderId(int orderId);
}
