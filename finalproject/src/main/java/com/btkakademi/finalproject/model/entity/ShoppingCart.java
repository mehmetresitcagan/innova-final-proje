package com.btkakademi.finalproject.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // .........
    @ManyToMany
    @JoinTable(name = "alisveris_sepeti_like", joinColumns = @JoinColumn(name = "sepet_id"), inverseJoinColumns = @JoinColumn(name = "urun_id"))
    private List<Product> products;
    // ........

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getUserId() {
        return user.getUserId();
    }

    public void setUserId(int userId) {
        this.user.setUserId(userId);
    }
    /*
     * public List<ProductDto> getItems() {
     * return items;
     * }
     * 
     * public void setItems(List<ProductDto> items) {
     * this.items = items;
     * }
     */
}
