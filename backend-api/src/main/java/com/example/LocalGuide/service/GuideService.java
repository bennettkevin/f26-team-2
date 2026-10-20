package com.example.LocalGuide.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LocalGuide.entity.Guide;
import com.example.LocalGuide.repository.GuideRepository;

@Service 
public class GuideService {
    private final GuideRepository repository;

    public GuideService(GuideRepository repository) {
        this.repository = repository;
    }

    public List<Guide> getAllGuides() {
        return repository.findAll();
    }

    public List<Guide> searchGuides(String f_name, String l_name, String email, String city, String state) {
        if (f_name != null && !f_name.isEmpty()) {
            return repository.findByFirstNameContainingIgnoreCase(f_name);
        } else if (l_name != null && !l_name.isEmpty()) {
            return repository.findByLastNameContainingIgnoreCase(l_name);
        } else if (email != null && !email.isEmpty()) {
            return repository.findByEmailContainingIgnoreCase(email);
        } else if (city != null && !city.isEmpty() && state != null && !state.isEmpty()) {
            return repository.findByCityAndStateContainingIgnoreCase(city, state);
        } else if (city != null && !city.isEmpty()) {
            return repository.findByCityContainingIgnoreCase(city);
        } else if (state != null && !state.isEmpty()) {
            return repository.findByStateContainingIgnoreCase(state);
        } else {
            return repository.findAll();
        }
    }

    public Guide getGuideById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Guide createGuide(Guide guide) {
        return repository.save(guide);
    }

    public Guide updateGuide(Long id, Guide updatedGuide) {
        Guide existingGuide = repository.findById(id).orElse(null);
        if (existingGuide != null) {
            existingGuide.setFName(updatedGuide.getFName());
            existingGuide.setLName(updatedGuide.getLName());
            existingGuide.setEmail(updatedGuide.getEmail());
            existingGuide.setPassword(updatedGuide.getPassword());
            existingGuide.setCity(updatedGuide.getCity());
            existingGuide.setState(updatedGuide.getState());
            existingGuide.setBio(updatedGuide.getBio());
            existingGuide.setProfilePicture(updatedGuide.getProfilePicture());
            return repository.save(existingGuide);
        }
        return null;
    }

    public void deleteGuide(Long id) {
        repository.deleteById(id);
    }
}
