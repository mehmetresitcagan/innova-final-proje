package com.btkakademi.finalproject.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "urunler")
public class Product {

    @Id
    @Column(name = "urun_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name = "urun_adi")
    private String productName;

    @Column(name = "urun_fiyat")
    private double price;

    @Column(name = "urun_aciklama")
    private String description;

    @Column(name = "urun_stok")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "urun_kategori_id")
    private Category category;

    // ..............

    @ManyToMany(mappedBy = "products")
    private List<ShoppingCart> shoppingCarts;

    // ..............

    // ..............

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    // ..............

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
