package com.example.LocalGuide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LocalGuide.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);

    List<Customer> findByLastNameContainingIgnoreCase(String lastName);

    List<Customer> findByEmailContainingIgnoreCase(String email);

    List<Customer> findByCityContainingIgnoreCase(String city);
    
    List<Customer> findByStateContainingIgnoreCase(String state);
    
    List<Customer> findByCityAndStateContainingIgnoreCase(String city, String state);
}
