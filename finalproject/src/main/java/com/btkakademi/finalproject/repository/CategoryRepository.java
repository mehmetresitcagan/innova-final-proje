package com.btkakademi.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.model.entity.Category;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from kategoriler", nativeQuery = true)
    List<Category> getAllCategories();

    List<Category> findByCategoryName(String categoryName);

    @Query(value = "select * from kategoriler", nativeQuery = true)
    Category updateCategoryId(int categoryId, CategoryDto category);

    // @Query(nativeQuery = true,value="select * from kategoriler")
    // List<Category> getAllCatsNative();

    // List<Category> findByName(String name);
    //@Query(value = "select * from kategoriler", nativeQuery = true)
    List<Category> findByCategoryNameIgnoreCase(String name);
    // List<Category> findByName(String name, Pageable pageable);

}
