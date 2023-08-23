package com.btkakademi.finalproject.service;

import com.btkakademi.finalproject.model.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();

    Admin getAdminById(int adminId);

    Admin createAdmin(Admin admin);

    Admin updateAdmin(int adminId, Admin admin);

    void deleteAdmin(int adminId);
}
