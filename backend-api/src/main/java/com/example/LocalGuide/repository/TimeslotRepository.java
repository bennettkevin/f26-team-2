package com.example.LocalGuide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LocalGuide.entity.Timeslot;

public interface TimeslotRepository extends JpaRepository<Timeslot, Long> {
    
    public List<Timeslot> findByGuideTourId(Long guideTourId);

    public List<Timeslot> findByGuideTourIdAndIsAvailable(Long guideTourId, Boolean isAvailable);

}
