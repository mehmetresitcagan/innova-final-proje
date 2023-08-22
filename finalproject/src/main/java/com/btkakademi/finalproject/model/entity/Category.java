package com.btkakademi.finalproject.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kategoriler")
public class Category {
    @Id
    @Column(name = "kategori_id")
    private int categoryId;

    @Column(name = "kategori_adi")
    private String categoryName;

    public int getId() {
        return categoryId;
    }

    public void setId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return categoryName;
    }

    public void setName(String categoryName) {
        this.categoryName = categoryName;
    }

}
