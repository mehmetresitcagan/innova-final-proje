package com.btkakademi.finalproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btkakademi.finalproject.exception.Order.OrderNotFoundException;
import com.btkakademi.finalproject.exception.category.CategoryNotFoundException;
import com.btkakademi.finalproject.model.dto.AddOrderDto;
import com.btkakademi.finalproject.model.dto.CategoryDto;
import com.btkakademi.finalproject.model.dto.OrderDto;
import com.btkakademi.finalproject.model.dto.ProductDto;
import com.btkakademi.finalproject.model.entity.Category;
import com.btkakademi.finalproject.model.entity.Order;
import com.btkakademi.finalproject.model.entity.Product;
import com.btkakademi.finalproject.model.entity.User;
import com.btkakademi.finalproject.repository.OrderRepository;
import com.btkakademi.finalproject.repository.ProductRepository;
import com.btkakademi.finalproject.repository.UserRepository;
import com.btkakademi.finalproject.service.OrderService;
import com.btkakademi.finalproject.util.mapper.CategoryMapper;
import com.btkakademi.finalproject.util.mapper.OrderMapper;
import com.btkakademi.finalproject.util.mapper.UserMapper;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional 
    public int addOrder(AddOrderDto orderdDto) {
        Optional<User> optionalUser = userRepository.findById(orderdDto.getUserId());
        List<Product> productList = productRepository.findAllById(orderdDto.getProductIds());
        Order order = new Order();
        order.setUser(optionalUser.get());
        order.setProducts(productList);
        repository.save(order);
        return order.getOrderId();
    }

    @Override
    public boolean deleteOrder(int orderId) {
        repository.deleteById(orderId);
        return true;
    }
/*
    @Override
    public OrderDto updateOrder(OrderDto orderdDto, int orderId) {
        boolean existsOrderById = existsOrderById(orderdDto.getOrderId());
        // Order order = OrderMapper.mapOrderDtoToEntity(orderdDto);
        if (!existsOrderById) {
          throw new OrderNotFoundException("İstenilen Sipariş bulunamadı.");
            //  insider.setOrderId(order.getOrderId());
          //  return insider;
        }
        User user = mapper.mapUserDtoToUserEntity(orderdDto.getUser());
        Order order = OrderMapper.mapOrderDtoToEntity(orderdDto);
        repository.save(order);
        userRepository.save(user);
        // throw atılacak (güncellenemedi gibi)
        return OrderMapper.mapOrderEntityToOrderDto(order);
    }*/
    @Override
    public OrderDto updateOrder(OrderDto orderDto, int orderId) {
        boolean existsOrderById = existsOrderById(orderId);
        
        if (!existsOrderById) {
            throw new OrderNotFoundException("İstenilen Sipariş bulunamadı.");
        }
        
        User user = mapper.mapUserDtoToUserEntity(orderDto.getUser());
        Order order = OrderMapper.mapOrderDtoToEntity(orderDto);
        
        order.setOrderId(orderId); // Güncellenen siparişin kimliğini ayarlayın
        
        // Siparişi güncelleyin ve güncellenen siparişi döndürün
        Order updatedOrder = repository.save(order);
        
        // Eğer User'ı da güncellemek istiyorsanız onu da güncelleyin ve UserRepository kullanarak kaydedin
        
        OrderDto updatedOrderDto = OrderMapper.mapOrderEntityToOrderDto(updatedOrder);
        return updatedOrderDto;
    }
    

/* 
    @Override
public OrderDto updateOrder(OrderDto orderDto, int orderId) {
    if (repository.existsById(orderId)) {
        Order existingOrder = repository.getById(orderId);
        
        // Update the properties of existingOrder with the new values from orderDto
        existingOrder.setUser(UserMapper.mapUserDtoToEntity(orderDto.getUser()));  // Assuming there's a UserMapper similar to OrderMapper
        
        // Update other properties similarly
        
        repository.save(existingOrder);
        
        return OrderMapper.mapOrderEntityToOrderDto(existingOrder);
    } else {
        // Order not found, throw an exception or handle accordingly
        throw new NotFoundException("Order with ID " + orderId + " not found");
    }
}
*/
    @Override
    public boolean existsOrderById(int orderId) {
        return repository.existsById(orderId);
    }

    @Override
    public OrderDto searchOrderByOrderId(int orderId) {
        // Burada veritabanından siparişi almanız gerekiyor. Örnek olarak repository kullanımını gösteriyorum.
        Optional<Order> order = repository.findById(orderId);
        if (order != null) {
            Order order2 = order.get();
            OrderDto orderDto = OrderMapper.mapOrderEntityToOrderDto(order2);
            return orderDto;
        } else {
            // Sipariş bulunamazsa uygun bir işlem yapılmalı.
            throw new OrderNotFoundException("Order with ID " + orderId + " not found");
        }
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = repository.getAllOrders();
        List<OrderDto> orderDtos = OrderMapper.mapOrderListToOrderDtoList(orders);
        return orderDtos;
    }
    @Override
    public List<ProductDto> getAllProducts(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }
    /*
     * @Override
public List<ProductDto> getAllProducts(int orderId) {
    Optional<Order> orderOptional = repository.findById(orderId);
    if (orderOptional.isPresent()) {
        Order order = orderOptional.get();
        List<Product> products = order.getProducts(); // Burada siparişin ürünlerini alın (örneğin getProducts metoduyla)
        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductMapper.INSTANCE.mapProductEntityToProductDto(product)) // ProductMapper, Product entity'sini ProductDto'ya dönüştüren bir sınıf olmalı
                .collect(Collectors.toList());
        return productDtos;
    } else {
        throw new OrderNotFoundException("Order with ID " + orderId + " not found");
    }
}

     */

}
