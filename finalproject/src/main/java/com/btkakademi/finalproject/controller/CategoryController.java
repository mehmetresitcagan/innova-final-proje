package com.btkakademi.finalproject.controller;

<<<<<<< Updated upstream
import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.model.vm.CategoryVm.AddCategoryVm;
import com.btkakademi.finalproject.model.vm.CategoryVm.UpdateCategoryVm;
import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.service.CategoryService;
import com.btkakademi.finalproject.util.mapper.CategoryMapper;

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
    private final CategoryService categoryService;

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
        return categoryService.updateCategory(Category);
=======
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @GetMapping(value = "")
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getAllCategories();
        logger.info("Listeleme Başarılı");
        return categoryList;
    }

    @GetMapping(value = "/{id}")
    public CategoryDto getByCategoryId(@PathVariable("id") int id) {
        CategoryDto category = categoryService.getCategoryById(id);
        return category;
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<CategoryDto> searchByName(@PathVariable("name") String categoryName) {
        List<CategoryDto> categoryList = categoryService.searchCategoryByName(categoryName);
        return categoryList;
    }

    @PostMapping(value = "")
    public int addCategory(@RequestBody AddCategoryVm categoryVm) {
        int recordedId = categoryService.addCategory(CategoryMapper.mapAddVmToDto(categoryVm));
        return recordedId;
>>>>>>> Stashed changes
    }

    @PutMapping(value = "")
    public CategoryDto updateCategory(@RequestBody UpdateCategoryVm categoryVm) {
        CategoryDto vm = categoryService.updateCategory(CategoryMapper.mapUpdateVmToDto(categoryVm));
        return vm;
    }

<<<<<<< Updated upstream
    @GetMapping("/search")
    public List<Category> searchCategoryByName(@RequestParam String categoryName) {
        return categoryService.searchCategoryByName(categoryName);
    }
=======
>>>>>>> Stashed changes
}
