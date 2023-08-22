package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public CategoryDto getCategoryById(@PathVariable int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping
    public int addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{categoryId}")
    public CategoryDto updateCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        categoryDto.setCategoryId(categoryId);
        return categoryService.updateCategory(categoryDto);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/search")
    public List<CategoryDto> searchCategoryByName(@RequestParam String categoryName) {
        return categoryService.searchCategoryByName(categoryName);
    }
}
