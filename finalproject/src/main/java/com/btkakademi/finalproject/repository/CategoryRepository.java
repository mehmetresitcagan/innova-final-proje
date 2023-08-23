package com.btkakademi.finalproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.btkakademi.finalproject.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("select c from Category c")
    List<Category> getAllCats();

    @Query(nativeQuery = true,value="select * from kategoriler")
    List<Category> getAllCatsNative();

    List<Category> findByName(String categoryName);
    List<Category> findByNameIgnoreCase(String categoryName);


<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
=======
>>>>>>> Stashed changes

import com.btkakademi.finalproject.model.entity.Category;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryName(String categoryName);

    @Query(value = "select * from kategoriler", nativeQuery = true)
    List<Category> getAllCategories();
}
