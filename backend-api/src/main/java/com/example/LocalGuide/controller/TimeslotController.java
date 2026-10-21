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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.LocalGuide.entity.Timeslot;
import com.example.LocalGuide.service.TimeslotService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/timeslots")
public class TimeslotController {

    private final TimeslotService timeslotService;

    public TimeslotController(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    @GetMapping ("/guide-tour/{guideTourId}") 
    public List<Timeslot> getTimeslotsByGuideTourId(@PathVariable Long guideTourId) {
        return timeslotService.getTimeslotsByGuideTourId(guideTourId);
    }

    @GetMapping ("/guide-tour/{guideTourId}/available") 
    public List<Timeslot> getAvailableTimeslotsByGuideTourId(@PathVariable Long guideTourId) {
        return timeslotService.getAvailableTimeslotsByGuideTourId(guideTourId);
    }

    @GetMapping ("/guide-tour/{guideTourId}/unavailable") 
    public List<Timeslot> getUnavailableTimeslotsByGuideTourId(@PathVariable Long guideTourId) {
        return timeslotService.getUnavailableTimeslotsByGuideTourId(guideTourId);
    }

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public Timeslot createTimeslot(@Valid @RequestBody Timeslot timeslot) {
        return timeslotService.createTimeslot(timeslot);
    }

    @PutMapping ("/{id}") 
    public Timeslot updateTimeslot(@PathVariable Long id, @Valid @RequestBody Timeslot updatedTimeslot) {
        return timeslotService.updateTimeslot(id, updatedTimeslot);
    }

    @DeleteMapping ("/{id}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTimeslot(@PathVariable Long id) {
        timeslotService.deleteTimeslot(id);
    }
}
