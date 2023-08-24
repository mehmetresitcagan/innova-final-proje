package com.btkakademi.finalproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.btkakademi.finalproject.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from kullanicilar", nativeQuery = true)
    List<User> findAll();

    Optional<User> findById(int userId);

    boolean existsById(int userId);

    void deleteById(int userId);

    User findByUsername(String username);

    // Kullanıcının ad ve soyadına göre kullanıcıyı bulma
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    // E-posta adresine göre kullanıcıyı bulma
    User findByEmail(String email);

    // Kullanıcının adresine göre kullanıcıları bulma
    List<User> findByAddress(String address);

}
