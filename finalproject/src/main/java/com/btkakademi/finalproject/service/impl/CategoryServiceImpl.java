package com.btkakademi.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.repository.CategoryRepository;
import com.btkakademi.finalproject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public int addCategory(Category category) {
        repository.save(category);
        return category.getCategoryId();
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        repository.deleteById(categoryId);
        return true;
    }

    @Override
    public Category updateCategory(Category category, int categoryId) {
        Category insider = getCategoryById(categoryId);
        if (repository.existsById(categoryId)) {
            insider.setCategoryId(category.getCategoryId());
            insider.setCategoryName(category.getCategoryName());
            return insider;
        }
        // throw atılacak (güncellenemedi gibi)
        return new Category();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return category;
    }

    @Override
    public boolean existsCategoryById(int categoryId) {
        return repository.existsById(categoryId);
    }

    // Hata mesajları girilirken else kısmı düzeltilecek.
    @Override
    public List<Category> searchCategoriesByCategoryName(String categoryName) {
        List<Category> categories = repository.findByCategoryName(categoryName);
        return categories;
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

}
