package com.example.LocalGuide.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.LocalGuide.entity.Guide;
import com.example.LocalGuide.service.GuideService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/guides")
public class GuideController {

    private final GuideService guideService;

    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping 
    public List<Guide> getAllGuides() {
        return guideService.getAllGuides();
    }

    @GetMapping ("/search") 
    public List<Guide> searchGuides(
            @RequestParam(required = false) String f_name,
            @RequestParam(required = false) String l_name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {
        return guideService.searchGuides(f_name, l_name, email, city, state);
    }

    @GetMapping ("/{id}") 
    public Guide getGuideById(@PathVariable Long id) {
        return guideService.getGuideById(id);
    }

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public Guide createGuide(@Valid @RequestBody Guide guide) {
        return guideService.createGuide(guide);
    }

    @PutMapping ("/{id}") 
    public Guide updateGuide(@PathVariable Long id, @Valid @RequestBody Guide updatedGuide) {
        return guideService.updateGuide(id, updatedGuide);
    }
}
