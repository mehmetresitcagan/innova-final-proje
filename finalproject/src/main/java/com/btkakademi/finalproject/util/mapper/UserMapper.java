package com.btkakademi.finalproject.util.mapper;

import com.btkakademi.finalproject.model.dto.UserDto;
import com.btkakademi.finalproject.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapUserEntityToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setAddress(user.getAddress());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        // Eğer OrderMapper sınıfınızı kullanıyorsanız aşağıdaki şekilde dönüşümü yapabilirsiniz.
        userDto.setOrders(OrderMapper.mapOrderListToOrderDtoList(user.getOrders()));
        return userDto;
    }

    public User mapUserDtoToUserEntity(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setAddress(userDto.getAddress());
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setRoles(userDto.getRoles());
        // Eğer OrderMapper sınıfınızı kullanıyorsanız aşağıdaki şekilde dönüşümü yapabilirsiniz.
        user.setOrders(OrderMapper.mapOrderDtoListToOrderList(userDto.getOrders()));
        return user;
    }
}
