package com.btkakademi.finalproject.model.entity;

import java.util.List;

import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.dto.ProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alisveris_sepeti")
public class ShoppingCart {

    @Id
    @Column(name = "sepet_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shoppingCartId;

    @Column(name = "sepet_urun_miktari")
    private List<Integer> productAmount;

    @OneToMany
    private int userId;

    // Liste mi yoksa tek bir product mı
    @ManyToMany
    private List<ProductDto> items;

    @OneToOne
    private OrderDto order;

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ProductDto> getItems() {
        return items;
    }

    public void setItems(List<ProductDto> items) {
        this.items = items;
    }

}