package com.btkakademi.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btkakademi.finalproject.model.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
