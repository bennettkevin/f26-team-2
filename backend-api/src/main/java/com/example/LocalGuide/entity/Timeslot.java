package com.example.LocalGuide.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table (name = "timeslots")
public class Timeslot {
    @Id 
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    @Column (name = "start_time", nullable = false, length = 50)
    private LocalDateTime startTime;

    @NotBlank 
    @Column (name = "end_time", nullable = false, length = 50)
    private LocalDateTime endTime;

    @NotBlank 
    @Column (name = "is_available", nullable = false)
    private Boolean isAvailable;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "guide_tour_id", nullable = false)
    private GuideTour guideTour;

    @OneToOne(mappedBy = "timeslot", fetch = FetchType.LAZY)
    @JsonIgnore
    private Booking booking;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public GuideTour getGuideTour() {
        return guideTour;
    }

    public void setGuideTour(GuideTour guideTour) {
        this.guideTour = guideTour;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking){
        this.booking = booking;
    }
}
