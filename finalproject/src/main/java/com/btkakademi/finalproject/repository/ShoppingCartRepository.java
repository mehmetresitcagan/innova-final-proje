package com.btkakademi.finalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.btkakademi.finalproject.model.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    @Query(value = "select * from alisveris_sepeti", nativeQuery = true)
    public Optional<ShoppingCart> findAll(int cartId);

}