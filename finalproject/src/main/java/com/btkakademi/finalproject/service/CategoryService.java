package com.btkakademi.finalproject.service;

import java.util.List;

import com.btkakademi.finalproject.model.entity.Category;

public interface CategoryService {

    int addCategory(Category category);

    boolean deleteCategory(int categoryId);

    Category updateCategory(Category category, int categoryId);

    Category getCategoryById(int categoryId);

    boolean existsCategoryById(int categoryId);

    List<Category> getAllCategories();

    List<Category> searchCategoriesByCategoryName(String categoryName);
}
