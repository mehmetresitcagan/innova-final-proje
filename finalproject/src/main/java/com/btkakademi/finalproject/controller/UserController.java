package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.entity.User;
import com.btkakademi.finalproject.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users != null) {
            logger.info("Kullanıcı listeleme başarılı");
            return ResponseEntity.ok(users);
        }
        logger.info("Kullanıcı listeleme başarısız");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@RequestBody int userId) {
        User userById = userService.getUserById(userId);
        if (userById != null) {
            logger.info("Kullanıcı bulundu.");
            return ResponseEntity.ok(userById);
        }
        logger.info("Kullanıcı bulunamadı.");
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = userService.createUser(user);
        if (createUser != null) {
            logger.info("Kullanıcı oluşturuldu.");
            return ResponseEntity.ok(createUser);
        }
        logger.info("Kullanıcı oluşturulamadı.");
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user) {
        User updateUser = userService.updateUser(userId, user);
        if (updateUser != null) {
            logger.info("Kullanıcı güncellendi.");
            return ResponseEntity.ok(updateUser);
        }
        logger.info("Kullanıcı güncellenemedi.");
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        logger.info("Kullanıcı silindi.");
        userService.deleteUser(userId);
    }
}
