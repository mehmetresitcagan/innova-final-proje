package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "")
    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();

    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping(value = "")
    public ResponseEntity<String> addCategory(@RequestBody Category Category) {
        categoryService.addCategory(Category);

        return ResponseEntity.ok("Başarılı");
    }

    @PutMapping("/{categoryId}")
    public Category updateCategory(@PathVariable int categoryId, @RequestBody Category Category) {
        Category.setCategoryId(categoryId);
        return categoryService.updateCategory(Category, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable int categoryId) {
        boolean existsCategoryById = categoryService.existsCategoryById(categoryId);
        if (existsCategoryById) {
            categoryService.deleteCategory(categoryId);
            return true;
        }
        return false;
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<Category> searchCategoryByCategoryName(@PathVariable("name") String categoryName) {
        List<Category> categoryList = categoryService.searchCategoriesByCategoryName(categoryName);
        return categoryList;
    }
}
