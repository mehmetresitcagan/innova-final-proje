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

    @GetMapping(value = "") // başarılı (full)
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getAllCategories();
        if(categoryList != null){
            logger.info("Kategoriler Listelendi");
            return ResponseEntity.ok(categoryList);
        }
            logger.info("Kategoriler Listeleme Başarısız");
            return ResponseEntity.notFound().build();
        // return categoryService.getAllCategories();

    }

    @GetMapping("/{categoryId}") // başarılı (id + name)
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);
        if(category != null){
            logger.info("Kategori Basariyla Goruntulendi");
            return ResponseEntity.ok(category);
        }
        logger.info("getCategoryById Hata!");
        return ResponseEntity.notFound().build();
        

        // return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("") // bu tammamdır -- id dönüyor
    public int addCategory(@RequestBody CategoryDto categoryDto) {
        int categoryId = categoryService.addCategory(categoryDto);
        return categoryId;
    }

    @PutMapping("/{categoryId}") // başarılı
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.updateCategory(categoryDto);
        if(category != null){
            logger.info("Kategori Basariyla Guncellendi");
            return ResponseEntity.ok(category);
        }
        logger.info("Kategori Guncelleme Basarisiz");
        return ResponseEntity.notFound().build();

    }

    @GetMapping(value = "/searchByName/{name}")
    public ResponseEntity<List<Category>> searchByName(@PathVariable("name") String name) {
        List<Category> categoryList = categoryService.searchCategoriesByCategoryName(name);
        if(categoryList.size()<0){
            logger.info("Kategori Bulundu");
            return ResponseEntity.ok(categoryList);
        }
        logger.info("Kategori Bulunamadi");
        return ResponseEntity.notFound().build();
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
