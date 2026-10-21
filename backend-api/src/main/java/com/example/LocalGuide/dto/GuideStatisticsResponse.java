package com.example.LocalGuide.dto;

import com.example.LocalGuide.entity.Guide;

public record GuideStatisticsResponse(
    Long id,
    String f_name, 
    String l_name,
    int totalTours,
    int totalTimeslots,
    int availableTimeslots,
    int unavailableTimeslots) {
        public static GuideStatisticsResponse from(Guide guide, int totalTours, int totalTimeslots, int availableTimeslots, int unavailableTimeslots) {
            return new GuideStatisticsResponse(
                guide.getId(),
                guide.getFName(),
                guide.getLName(),
                totalTours,
                totalTimeslots,
                availableTimeslots,
                unavailableTimeslots
            );
        }
}
