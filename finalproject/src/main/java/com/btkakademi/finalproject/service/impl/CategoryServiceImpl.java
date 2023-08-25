package com.btkakademi.finalproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.controller.CategoryController;
import com.btkakademi.finalproject.exception.UserBasedException;
import com.btkakademi.finalproject.exception.category.CategoryNotFoundException;
import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.repository.CategoryRepository;
import com.btkakademi.finalproject.repository.ProductRepository;
import com.btkakademi.finalproject.service.CategoryService;
import com.btkakademi.finalproject.util.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;
    ProductRepository productRepository;


    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    // dto yu entity yap
    // entitiyi kontrol et
    // entitiyi ekle
    // entitiyi dtoya dönüştürü
    // dto dön
    @Override
    public int addCategory(CategoryDto categoryDto) {

        List<Category> categories = repository.findByCategoryName(categoryDto.getCategoryName());
        if (categories.size() > 0) {
            logger.error("Kullanici var olan bir kategori eklemeye calisirken zortladi", categoryDto.getCategoryName());
            throw new UserBasedException("Var olan kategori tekrar eklenemez.");
        }

        Category category = CategoryMapper.mapCategoryDtoToEntity(categoryDto);
        repository.save(category);
        return category.getCategoryId();
    }/* 
        // List<Category> categoryList =
        // CategoryMapper.mapCategoryDtoListToCategoryList(categoryDto);
        // Öncelikle, eklemeye çalıştığınız kategorinin mevcut olup olmadığını kontrol
        // etmelisiniz.
    //    Category existsCategory = repository.findByCategoryName(CategoryMapper.mapCategoryDtoToEntity(categoryDto));
        Category category = CategoryMapper.mapCategoryDtoToEntity(categoryDto);
        List<Category> existsCategory = repository.findByCategoryName(category.getCategoryName());

        if (existsCategory.size()>0) {
            logger.error("Kullanici var olan bir kategori eklemeye calisirken zortladi", categoryDto.getCategoryName());
            throw new UserBasedException("Var olan kategori tekrar eklenemez.");
        }
        repository.save(category);
        CategoryDto newCategory = CategoryMapper.mapCategoryEntityToCategoryDto(category);
        
        // Mevcut olmayan bir kategori ise, kaydedebilirsiniz.
        
        

        // Kaydedilen kategoriyi geri dönebilirsiniz.
        //CategoryDto addedCategoryDto = CategoryMapper.mapCategoryEntityToCategoryDto(newCategory);
        return newCategory;

    }
*/
    /*
     * @Override
     * public boolean deleteCategory(int categoryId) {
     * repository.deleteById(categoryId);
     * return true;
     * }
     */

     @Override
     public boolean deleteCategory(int categoryId) {
         Optional<Category> categoryOptional = repository.findById(categoryId);
     
         if (categoryOptional.isPresent()) {
             Category category = categoryOptional.get();
             List<Product> products = category.getProducts();
             for (Product product : products) {
                // Ürünü ilgili listelerden çıkar
                //product.getShoppingCarts().clear(); // Örnek olarak ShoppingCart listesinden çıkar
                //product.getOrders().clear(); // Örnek olarak Order listesinden çıkar
                
                // Ürünü veritabanından sil
                productRepository.delete(product);
            }
             repository.delete(category);
             return true;
         }
         return false;
     }

    
    /*
     * @Override
     * public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
     * CategoryDto insider = getCategoryById(categoryId);
     * if (repository.existsById(categoryId)) {
     * insider.setCategoryId(categoryDto.getCategoryId());
     * insider.setCategoryName(categoryDto.getCategoryName());
     * return insider;
     * }
     * // throw atılacak (güncellenemedi gibi)
     * return new CategoryDto();
     * }
     */

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        boolean existCategoryById = existsCategoryById(categoryDto.getCategoryId());
        if (!existCategoryById) {
            throw new CategoryNotFoundException("İstenilen Kategori bulunamadı.");
        }
        Category entity = CategoryMapper.mapCategoryDtoToEntity(categoryDto);
        repository.save(entity);

        return CategoryMapper.mapCategoryEntityToCategoryDto(entity);
    }

    /*
     * @Override
     * public CategoryDto getCategoryById(int categoryId) {
     * CategoryDto category = new CategoryDto();
     * category.setCategoryId(categoryId);
     * return category;
     * }
     */
    @Override
    public CategoryDto getCategoryById(int category_Id) throws CategoryNotFoundException {
        Optional<Category> opetionalCategory = repository.findById(category_Id);
        if (!opetionalCategory.isPresent()) {
            // throw new NotFoundException("Aranılan kayıt bulunamadı.");
            throw new CategoryNotFoundException("Aranılan kategori bulunamadı.");
        }

        Category category = opetionalCategory.get();
        CategoryDto categoryDto = CategoryMapper.mapCategoryEntityToCategoryDto(category);
        return categoryDto;

    }

    /*
     * @Override
     * public boolean existsCategoryById(int categoryId) {
     * return repository.existsById(categoryId);
     * }
     */
    @Override
    public boolean existsCategoryById(int categoryId) {
        boolean existsById = repository.existsById(categoryId);
        return existsById;
    }
    

    /*
     * // Hata mesajları girilirken else kısmı düzeltilecek.
     * 
     * @Override
     * public List<CategoryDto> searchCategoriesByCategoryName(String categoryName)
     * {
     * List<CategoryDto> categories = repository.findByCategoryName(categoryName);
     * return categories;
     * }
     */
    /* 
    @Override
    public CategoryDto searchCategoriesByCategoryName(String categoryName) {
        CategoryDto categoryDto = repository.findByCategoryName(categoryName);
        Category category = CategoryMapper.mapCategoryDtoToEntity(categoryDto);
        if(category != null){
            throw new CategoryNotFoundException("İstenilen Kategori bulunamadı.");
        }
        CategoryDto categoryDto2 = CategoryMapper.mapCategoryEntityToCategoryDto(category);
        return categoryDto2;
    
    }*/

    @Override
    public List<CategoryDto> getAllCategories() { // category aldım dto çevrdim
        List<Category> categoryList = repository.getAllCategories();
        List<CategoryDto> resultList = CategoryMapper
                .mapCategoryListToCategoryDtoList(categoryList);
        return resultList;
    }

    @Override
    public List<Category> searchCategoriesByCategoryName(String categoryName) {
        List<Category> categoryList = repository.findByCategoryNameIgnoreCase(categoryName);
        //Category category = repository.findByNameIgnoreCase(categoryName);
       // CategoryDto categoryDto = CategoryMapper.mapCategoryEntityToCategoryDto(category);
        return categoryList;
    }
        

    

}
