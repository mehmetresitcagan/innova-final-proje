package com.btkakademi.finalproject.service.impl;

import java.util.List;

<<<<<<< Updated upstream
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.controller.CategoryController;
import com.btkakademi.finalproject.exception.UserBasedException;
import com.btkakademi.finalproject.model.dto.CategoryDto;
>>>>>>> Stashed changes
import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.repository.CategoryRepository;
import com.btkakademi.finalproject.service.CategoryService;
import com.btkakademi.finalproject.util.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
<<<<<<< Updated upstream
    CategoryRepository repository;

    @Override
    public int addCategory(Category category) {
        repository.save(category);
=======
    private CategoryRepository categoryRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Override
    public int addCategory(CategoryDto categoryDto) {
        List<Category> categories = categoryRepository.findByName(categoryDto.getName());
        if (categories.size() > 0) {
            logger.error("Kullanici var olan bir kategori eklemeye calisirken zortladi", categoryDto.getName());
            throw new UserBasedException("Var olan kategori tekrar eklenemez.");
        }

        Category category = CategoryMapper.mapCategoryDtoToEntity(categoryDto);
        categoryRepository.save(category);
>>>>>>> Stashed changes
        return category.getCategoryId();
    }

    @Override
    public boolean deleteCategory(int categoryId) {

        if (existsCategoryById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            return true;
        }
        return false;
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
<<<<<<< Updated upstream
    public List<Category> getAllCategories() {
        return repository.findAll();
=======
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.getAllCats();
        List<CategoryDto> resultList = CategoryMapper
                .mapCategoryListToCategoryDtoList(categoryList);
        return resultList;
>>>>>>> Stashed changes
    }
}
