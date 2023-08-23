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
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

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
        return categoryService.updateCategory(Category);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/search")
    public List<Category> searchCategoryByName(@RequestParam String categoryName) {
        return categoryService.searchCategoryByName(categoryName);
    }
}
