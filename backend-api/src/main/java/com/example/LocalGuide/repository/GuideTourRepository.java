package com.example.LocalGuide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LocalGuide.entity.GuideTour;

public interface GuideTourRepository extends JpaRepository<GuideTour, Long> {
    List<GuideTour> findByNameContainingIgnoreCase(String name);

    List<GuideTour> findByCityContainingIgnoreCase(String city);

    List<GuideTour> findByStateContainingIgnoreCase(String state);

    List<GuideTour> findByCityAndStateContainingIgnoreCase(String city, String state);

    List<GuideTour> findByGuideId(Long guideId);
}
