package com.btkakademi.finalproject.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.model.vm.CategoryVm.AddCategoryVm;
import com.btkakademi.finalproject.model.vm.CategoryVm.UpdateCategoryVm;


public class CategoryMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    public static void getMapper() {
        if (mapper == null)
            mapper = new DozerBeanMapper();
    }

    public static CategoryDto mapCategoryToCategoryDto(Category category) {
        CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    public static List<CategoryDto> mapCategoryListToCategoryDtoList(List<Category> categoryList) {
        List<CategoryDto> returnList = new ArrayList<CategoryDto>();
        for (Category category : categoryList) {
            CategoryDto categoryDto = mapCategoryToCategoryDto(category);
            returnList.add(categoryDto);
        }
        return returnList;
    }

    public static CategoryDto mapAddVmToDto(AddCategoryVm categoryVm) {
        CategoryDto categoryDto = mapper.map(categoryVm, 
                                                    CategoryDto.class);
        return categoryDto;
    }

    public static CategoryDto mapUpdateVmToDto(UpdateCategoryVm categoryVm) {
        CategoryDto categoryDto = mapper.map(categoryVm, 
                                                        CategoryDto.class);
        return categoryDto;
    }

    public static Category mapCategoryDtoToEntity(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        return category;
    }

    public static <T, U> List<U> map(final List<T> source, final Class<U> destType) {

        final List<U> dest = new ArrayList<>();

        for (T element : source) {
            dest.add(mapper.map(element, destType));
        }

        return dest;
    }

}
