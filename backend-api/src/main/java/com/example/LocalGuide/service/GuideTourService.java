package com.example.LocalGuide.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LocalGuide.entity.GuideTour;
import com.example.LocalGuide.repository.GuideTourRepository;

@Service
public class GuideTourService {

    private final GuideTourRepository guideTourRepository;

    public GuideTourService(GuideTourRepository guideTourRepository) {
        this.guideTourRepository = guideTourRepository;
    }

    public List<GuideTour> getAllGuideTours() {
        return guideTourRepository.findAll();
    }

    public List<GuideTour> searchGuideTours(String name, String city, String state) {
        if (name != null && !name.isEmpty()) {
            return guideTourRepository.findByTourNameContainingIgnoreCase(name);
        } else if (city != null && !city.isEmpty() && state != null && !state.isEmpty()) {
            return guideTourRepository.findByTourCityAndTourStateContainingIgnoreCase(city, state);
        } else if (city != null && !city.isEmpty()) {
            return guideTourRepository.findByTourCityContainingIgnoreCase(city);
        } else if (state != null && !state.isEmpty()) {
            return guideTourRepository.findByTourStateContainingIgnoreCase(state);
        } else {
            return guideTourRepository.findAll();
        }
    }

    public List<GuideTour> getGuideToursByGuideId(Long guideId) {
        return guideTourRepository.findByGuideId(guideId);
    }

    public GuideTour getGuideTourById(Long id) {
        return guideTourRepository.findById(id).orElse(null);
    }

    public GuideTour createGuideTour(GuideTour guideTour) {
        return guideTourRepository.save(guideTour);
    }

    public GuideTour updateGuideTour(Long id, GuideTour updatedGuideTour) {
        GuideTour existingGuideTour = guideTourRepository.findById(id).orElse(null);
        if (existingGuideTour != null) {
            existingGuideTour.setTourName(updatedGuideTour.getTourName());
            existingGuideTour.setTourDescription(updatedGuideTour.getTourDescription());
            existingGuideTour.setTourCity(updatedGuideTour.getTourCity());
            existingGuideTour.setTourState(updatedGuideTour.getTourState());
            existingGuideTour.setTourPrice(updatedGuideTour.getTourPrice());
            existingGuideTour.setTimeslots(updatedGuideTour.getTimeslots());
            existingGuideTour.setTourImage(updatedGuideTour.getTourImage());
            existingGuideTour.setGuide(updatedGuideTour.getGuide());
            return guideTourRepository.save(existingGuideTour);
        }
        return null;
    }

    public void deleteGuideTour(Long id) {
        guideTourRepository.deleteById(id);
    }
}
