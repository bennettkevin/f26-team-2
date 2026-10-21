package com.example.LocalGuide.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LocalGuide.entity.Timeslot;
import com.example.LocalGuide.repository.TimeslotRepository;

@Service 
public class TimeslotService {
    private final TimeslotRepository repository;

    public TimeslotService(TimeslotRepository repository) {
        this.repository = repository;
    }

    public List<Timeslot> getTimeslotsByGuideTourId(Long guideTourId) {
        return repository.findByGuideTourId(guideTourId);
    }

    public List<Timeslot> getAvailableTimeslotsByGuideTourId(Long guideTourId) {
        return repository.findByGuideTourIdAndIsAvailable(guideTourId, true);
    }

    public List<Timeslot> getUnavailableTimeslotsByGuideTourId(Long guideTourId) {
        return repository.findByGuideTourIdAndIsAvailable(guideTourId, false);
    }

    public Timeslot createTimeslot(Timeslot timeslot) {
        return repository.save(timeslot);
    }

    public Timeslot updateTimeslot(Long id, Timeslot updatedTimeslot) {
        Timeslot existingTimeslot = repository.findById(id).orElse(null);
        if (existingTimeslot != null) {
            existingTimeslot.setStartTime(updatedTimeslot.getStartTime());
            existingTimeslot.setEndTime(updatedTimeslot.getEndTime());
            existingTimeslot.setIsAvailable(updatedTimeslot.getIsAvailable());
            return repository.save(existingTimeslot);
        }
        return null;
    }

    public void deleteTimeslot(Long id) {
        repository.deleteById(id);
    }
}
