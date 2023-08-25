package com.btkakademi.finalproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.finalproject.model.entity.User;
import com.btkakademi.finalproject.repository.UserRepository;
import com.btkakademi.finalproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        User userOptional = userRepository.findByEmail(email);
        return userOptional;
    }

    @Override
    public User createUser(User user) {
        User save = userRepository.save(user);
        return save ;
    }

    @Override
    public User updateUser(int userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setUserId(userId);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void userRoles(String roles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userRoles'");
    }

}
