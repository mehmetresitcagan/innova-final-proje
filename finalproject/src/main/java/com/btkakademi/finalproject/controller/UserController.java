package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.entity.User;
import com.btkakademi.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/All")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@RequestBody int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(value="/create")
    public User createUser(@RequestBody User user) { // userID de istiyor sıkıntı mı ? 
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {  // , @RequestParam String password eklenecek spring ssecurityde   
        userService.deleteUser(userId);
    }
}