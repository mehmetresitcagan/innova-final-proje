package com.btkakademi.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.btkakademi.finalproject.model.entity.Category;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryName(String categoryName);

    @Query(value = "select * from kategoriler", nativeQuery = true)
    List<Category> getAllCategories();
}
