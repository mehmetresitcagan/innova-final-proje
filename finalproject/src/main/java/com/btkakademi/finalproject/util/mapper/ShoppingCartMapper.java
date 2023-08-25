package com.btkakademi.finalproject.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.btkakademi.finalproject.model.dto.ShoppingCartDto;
import com.btkakademi.finalproject.model.entity.ShoppingCart;
import com.btkakademi.finalproject.model.vm.ShoppingCartVm.AddShoppingCartVm;
import com.btkakademi.finalproject.model.vm.ShoppingCartVm.UpdateShoppingCartVm;

public class ShoppingCartMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    public static ShoppingCartDto mapCategoryEntityToCategoryDto(ShoppingCart cart) {
        return mapper.map(cart, ShoppingCartDto.class);
    }

    public static List<ShoppingCartDto> mapCategoryListToCategoryDtoList(List<ShoppingCart> cartList) {
        List<ShoppingCartDto> returnList = new ArrayList<ShoppingCartDto>();
        for (ShoppingCart cart : cartList) {
            ShoppingCartDto cartDto = mapCategoryEntityToCategoryDto(cart);
            returnList.add(cartDto);
        }
        return returnList;
    }

    public static List<ShoppingCart> mapCategoryDtoListToCategoryList(List<ShoppingCartDto> cartDtoList) {
        List<ShoppingCart> returnList = new ArrayList<ShoppingCart>();
        for (ShoppingCartDto cartDto : cartDtoList) {
            ShoppingCart cart = mapCategoryDtoToEntity(cartDto);
            returnList.add(cart);
        }
        return returnList;
    }

    public static ShoppingCartDto mapAddVmToDto(AddShoppingCartVm cartVm) {
        ShoppingCartDto cartDto = mapper.map(cartVm,
                ShoppingCartDto.class);
        return cartDto;
    }

    public static ShoppingCartDto mapUpdateVmToDto(UpdateShoppingCartVm cartVm) {
        ShoppingCartDto cartDto = mapper.map(cartVm,
                ShoppingCartDto.class);
        return cartDto;
    }

    public static ShoppingCart mapCategoryDtoToEntity(ShoppingCartDto cartDto) {
        ShoppingCart cart = mapper.map(cartDto, ShoppingCart.class);
        return cart;
    }

    public static <T, U> List<U> map(final List<T> source, final Class<U> destType) {

        final List<U> dest = new ArrayList<>();

        for (T element : source) {
            dest.add(mapper.map(element, destType));
        }

        return dest;
    }

}
