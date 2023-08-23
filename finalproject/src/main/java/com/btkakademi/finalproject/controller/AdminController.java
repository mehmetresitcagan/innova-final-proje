package com.btkakademi.finalproject.controller;

import com.btkakademi.finalproject.model.entity.Admin;
import com.btkakademi.finalproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{adminId}")
    public Admin getAdminById(@PathVariable int adminId) {
        return adminService.getAdminById(adminId);
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/{adminId}")
    public Admin updateAdmin(@PathVariable int adminId, @RequestBody Admin admin) {
        return adminService.updateAdmin(adminId, admin);
    }

    @DeleteMapping("/{adminId}")
    public void deleteAdmin(@PathVariable int adminId) {
        adminService.deleteAdmin(adminId);
    }
}
