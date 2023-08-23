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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }

    @Override
    public Category updateCategory(Category category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    @Override
    public Category getCategoryById(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryById'");
    }

    @Override
    public boolean existsCategoryById(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsCategoryById'");
    }

    @Override
    public List<Category> searchCategoryByName(String categoryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchCategoryByName'");
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

}
