package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.service.CategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping(value = "/getAll") // başarılı (full)
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getAllCategories();
        logger.info("Listeleme Başarılı");
        return categoryList;

        // return categoryService.getAllCategories();

    }

    @GetMapping("/{categoryId}") // başarılı (id + name)
    public CategoryDto getCategoryById(@PathVariable int categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return category;

        // return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("") // bu tammamdır -- id dönüyor
    public int addCategory(@RequestBody CategoryDto categoryDto) {
        int categoryId = categoryService.addCategory(categoryDto);
        return categoryId;
    }

    @PutMapping("/{categoryId}") // başarılı
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.updateCategory(categoryDto);
        return category;
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<Category> searchByName(@PathVariable("name") String name) {
        List<Category> categoryList = categoryService.searchCategoriesByCategoryName(name);
        return categoryList;

    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable int categoryId) {
        boolean deleted = categoryService.deleteCategory(categoryId);

        if (deleted) {
            return ResponseEntity.ok("Kategori silindi");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
