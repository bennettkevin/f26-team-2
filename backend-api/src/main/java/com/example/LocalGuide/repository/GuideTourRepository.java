package com.example.LocalGuide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LocalGuide.entity.GuideTour;

public interface GuideTourRepository extends JpaRepository<GuideTour, Long> {
    List<GuideTour> findByTourNameContainingIgnoreCase(String name);

    List<GuideTour> findByTourCityContainingIgnoreCase(String city);

    List<GuideTour> findByTourStateContainingIgnoreCase(String state);

    List<GuideTour> findByTourCityAndTourStateContainingIgnoreCase(String city, String state);

    List<GuideTour> findByGuideId(Long guideId);
}
