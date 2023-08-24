package com.btkakademi.finalproject.service;

import java.util.List;

import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.model.entity.Category;

public interface CategoryService {

    int addCategory(CategoryDto categoryName);
    
   // int addCategoryById(int categoryDto);

    boolean deleteCategory(int categoryId);

    CategoryDto updateCategory(CategoryDto category);

    CategoryDto getCategoryById(int categoryId);

    boolean existsCategoryById(int categoryId);

    List<CategoryDto> getAllCategories();

    List<Category> searchCategoriesByCategoryName(String categoryName);
}
