package com.example.LocalGuide.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table (name = "guide_tours")
public class GuideTour {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    @Column (name = "tour_name", nullable = false, length = 100)
    private String tourName;

    @NotBlank 
    @Column (name = "tour_description", nullable = false, length = 500)
    private String tourDescription;

    @NotBlank 
    @Column (name = "tour_city", nullable = false, length = 100)
    private String tourCity;

    @NotBlank 
    @Column (name = "tour_state", nullable = false, length = 100)
    private String tourState;

    @NotNull
    @Column (name = "tour_price", nullable = false, length = 50)
    private Float tourPrice;

    @Column (name = "tour_image")
    private String tourImage;

    @OneToMany (mappedBy = "guideTour", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore 
    private List<Timeslot> timeslots;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "guide_id", nullable = false)
    private Guide guide;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    } 

    public String getTourCity() {
        return tourCity;
    }

    public void setTourCity(String tourCity) {
        this.tourCity = tourCity;
    }

    public String getTourState() {
        return tourState;
    }

    public void setTourState(String tourState) {
        this.tourState = tourState;
    }

    public Float getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(Float tourPrice) {
        this.tourPrice = tourPrice;
    }

    public String getTourImage() {
        return tourImage;
    }

    public void setTourImage(String tourImage) {
        this.tourImage = tourImage;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        if (timeslots != null && !timeslots.isEmpty()) {
            this.timeslots.clear();
            this.timeslots.addAll(timeslots);
        }
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

}
