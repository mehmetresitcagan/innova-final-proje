package com.btkakademi.finalproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btkakademi.finalproject.model.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
