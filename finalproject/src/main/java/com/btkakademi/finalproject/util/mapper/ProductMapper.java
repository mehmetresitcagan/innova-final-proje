package com.btkakademi.finalproject.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.model.vm.CategoryVm.AddCategoryVm;
import com.btkakademi.finalproject.model.vm.CategoryVm.UpdateCategoryVm;

public class ProductMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    public static ProductDto mapProductEntityToProductDto(Product product) {
        ProductDto productDto = mapper.map(product, ProductDto.class);
        productDto.setCategoryId(product.getCategory().getCategoryId());
        
        return productDto;
    }

    public static List<ProductDto> mapProductListToProductDtoList(List<Product> categoryList) {
        List<ProductDto> returnList = new ArrayList<ProductDto>();
        for (Product product : categoryList) {
            ProductDto productDto = mapProductEntityToProductDto(product);
            returnList.add(productDto);
        }

        return returnList;
    }

    public static List<Product> mapProductDtoListToProductList(List<ProductDto> categoryDtoList) {
        List<Product> returnList = new ArrayList<Product>();
        for (ProductDto productDto : categoryDtoList) {
            Product product = mapProductDtoToProductEntity(productDto);
            returnList.add(product);
        }
        return returnList;
    }

    public static ProductDto mapAddVmToDto(AddCategoryVm categoryVm) {
        ProductDto productDto = mapper.map(categoryVm,
                ProductDto.class);
        return productDto;
    }

    public static ProductDto mapUpdateVmToDto(UpdateCategoryVm categoryVm) {
        ProductDto productDto = mapper.map(categoryVm,
                ProductDto.class);
        return productDto;
    }

    public static Product mapProductDtoToProductEntity(ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        return product;
    }

    public static <T, U> List<U> map(final List<T> source, final Class<U> destType) {

        final List<U> dest = new ArrayList<>();

        for (T element : source) {
            dest.add(mapper.map(element, destType));
        }

        return dest;
    }

}
