package com.btkakademi.finalproject.service;

import java.util.List;

import com.btkakademi.finalproject.model.dto.CategoryDto;

public interface CategoryService {

    int addCategory(CategoryDto category);

    boolean deleteCategory(int categoryId);

    CategoryDto updateCategory(CategoryDto category);

    CategoryDto getCategoryById(int categoryId);

    boolean existsCategoryById(int categoryId);

    List<CategoryDto> searchCategoryByName(String categoryName);

    List<CategoryDto> getAllCategories();
}
