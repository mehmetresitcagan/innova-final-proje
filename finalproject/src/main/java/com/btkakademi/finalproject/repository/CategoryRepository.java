package com.btkakademi.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.btkakademi.finalproject.model.entity.Category;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // List<Category> findCategoryByName(String categoryName);

    @Query(value = "select * from kategoriler", nativeQuery = true)
    List<Category> getAllCategories();

    List<Category> findByCategoryName(String categoryName);

}
