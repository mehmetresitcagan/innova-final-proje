package com.btkakademi.finalproject.model.entity;

import com.btkakademi.finalproject.model.dto.ShoppingCartDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "siparisler")
public class Order {

    @Id
    @Column(name = "siparis_id")
    private int orderId;

    @Column(name = "toplam_tutari")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
