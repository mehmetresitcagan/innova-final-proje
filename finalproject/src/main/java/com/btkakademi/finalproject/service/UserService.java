package com.btkakademi.finalproject.service;

import com.btkakademi.finalproject.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int userId);

    User createUser(User user);

    User updateUser(int userId, User user);

    void deleteUser(int userId);

    User getByEmail(String email);

    void userRoles(String roles);
}
