package com.btkakademi.finalproject.service.impl;

import com.btkakademi.finalproject.model.entity.Admin;
import com.btkakademi.finalproject.repository.AdminRepository;
import com.btkakademi.finalproject.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    //private final AdminRepository adminRepository;

    @Autowired
    AdminRepository repository;

    @Override
    public List<Admin> getAllAdmins() {
        return repository.findAll();
    }

    @Override
    public Admin getAdminById(int adminId) {
        Optional<Admin> adminOptional = repository.findById(adminId);
        return adminOptional.orElse(null);
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin updateAdmin(int adminId, Admin admin) {
        if (repository.existsById(adminId)) {
            admin.setAdminId(adminId);
            return repository.save(admin);
        }
        return null;
    }

    @Override
    public void deleteAdmin(int adminId) {
        repository.deleteById(adminId);
    }
}
