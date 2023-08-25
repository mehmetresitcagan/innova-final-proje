package com.btkakademi.finalproject.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.entity.Order;
import com.btkakademi.finalproject.model.vm.OrderVm.AddOrderVm;
import com.btkakademi.finalproject.model.vm.OrderVm.UpdateOrderVm;

public class OrderMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();
    // public static Object INSTANCE;

    public static OrderDto mapOrderEntityToOrderDto(Order order) {
        OrderDto orderDto = mapper.map(order, OrderDto.class);
        return orderDto;
    }
    public static Order mapOrderDtoToOrderEntity(OrderDto orderDto) {
        Order order = mapper.map(orderDto, Order.class);
        return order;
    }
    
    public static List<OrderDto> mapOrderListToOrderDtoList(List<Order> orderList) {
        List<OrderDto> returnList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = mapOrderEntityToOrderDto(order);
            returnList.add(orderDto);
        }
        return returnList;
    }

    public static List<Order> mapOrderDtoListToOrderList(List<OrderDto> orderDtoList) {
        List<Order> returnList = new ArrayList<>();
        for (OrderDto orderDto : orderDtoList) {
            Order order = mapOrderDtoToEntity(orderDto);
            returnList.add(order);
        }
        return returnList;
    }
    

    public static OrderDto mapAddVmToDto(AddOrderVm orderVm) {
        OrderDto orderDto = mapper.map(orderVm, OrderDto.class);
        return orderDto;
    }

    public static OrderDto mapUpdateVmToDto(UpdateOrderVm orderVm) {
        OrderDto orderDto = mapper.map(orderVm, OrderDto.class);
        return orderDto;
    }

    public static Order mapOrderDtoToEntity(OrderDto orderDto) {
        Order order = mapper.map(orderDto, Order.class);
        return order;
    }

    public static <T, U> List<U> map(final List<T> source, final Class<U> destType) {
        final List<U> dest = new ArrayList<>();
        for (T element : source) {
            dest.add(mapper.map(element, destType));
        }
        return dest;
    }
}
