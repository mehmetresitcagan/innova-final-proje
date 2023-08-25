package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.dto.UserDto;
import com.btkakademi.finalproject.model.entity.User;
import com.btkakademi.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@RequestBody int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) { // userID de istiyor sıkıntı mı ?
        UserDto createUser = userService.createUser(user);
        return ResponseEntity.ok(createUser);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) { // , @RequestParam String password eklenecek spring ssecurityde
        userService.deleteUser(userId);
    }
}
