package com.example.LocalGuide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LocalGuide.entity.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    
    List<Guide> findByFirstNameContainingIgnoreCase(String firstName);

    List<Guide> findByLastNameContainingIgnoreCase(String lastName);

    List<Guide> findByEmailContainingIgnoreCase(String email);

    List<Guide> findByCityContainingIgnoreCase(String city);
    
    List<Guide> findByStateContainingIgnoreCase(String state);
    
    List<Guide> findByCityAndStateContainingIgnoreCase(String city, String state);
}
