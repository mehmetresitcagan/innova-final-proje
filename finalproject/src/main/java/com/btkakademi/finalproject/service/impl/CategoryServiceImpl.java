package com.btkakademi.finalproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public int addCategory(CategoryDto category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCategory'");
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    @Override
    public CategoryDto getCategoryById(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryById'");
    }

    @Override
    public boolean existsCategoryById(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsCategoryById'");
    }

    @Override
    public List<CategoryDto> searchCategoryByName(String categoryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchCategoryByName'");
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    }


}
