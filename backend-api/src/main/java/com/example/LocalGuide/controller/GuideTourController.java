package com.example.LocalGuide.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.LocalGuide.entity.GuideTour;
import com.example.LocalGuide.service.GuideTourService;

@RestController 
@RequestMapping ("/api/guidetours")
public class GuideTourController {
    private final GuideTourService guideTourService;

    public GuideTourController(GuideTourService guideTourService){
        this.guideTourService = guideTourService;
    }

    @GetMapping 
    public List<GuideTour> getAllGuideTours() {
        return guideTourService.getAllGuideTours();
    }

    @GetMapping ("/search")
    public List<GuideTour> searchGuideTours(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {
        return guideTourService.searchGuideTours(name, city, state);
    }

    @GetMapping ("/{id}")
    public GuideTour getGuideTourById(@PathVariable Long id) {
        return guideTourService.getGuideTourById(id);
    }

    @GetMapping ("/guide/{guideId}")
    public List<GuideTour> getGuideToursByGuideId(@PathVariable Long guideId) {
        return guideTourService.getGuideToursByGuideId(guideId);
    }

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public GuideTour createGuideTour(@RequestBody GuideTour guideTour) {
        return guideTourService.createGuideTour(guideTour);
    }

    @PutMapping ("/{id}")
    public GuideTour updateGuideTour(@PathVariable Long id, @RequestBody GuideTour updatedGuideTour) {
        return guideTourService.updateGuideTour(id, updatedGuideTour);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuideTour(@PathVariable Long id) {
        guideTourService.deleteGuideTour(id);
    }

}
