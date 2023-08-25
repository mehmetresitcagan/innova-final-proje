package com.btkakademi.finalproject.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kullanicilar")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "user_adres")
    private String address;

    @Column(name = "user_kullanici_adi")
    private String username;

    @Column(name = "user_adi")
    private String firstName;

    @Column(name = "user_soyadi")
    private String lastName;

    @Column(name = "user_sifre")
    private String password;

    @Column(name = "user_eposta")
    private String email;

    @Column(name = "Yetkilendirme")
    private String roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.address = ""; // Varsayılan adres
        this.firstName = ""; // Varsayılan ad
        this.lastName = ""; // Varsayılan soyad
        this.email = ""; // Varsayılan email
        this.roles = ""; // Varsayılan rol
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
