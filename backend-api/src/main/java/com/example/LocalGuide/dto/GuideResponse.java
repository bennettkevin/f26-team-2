package com.example.LocalGuide.dto;

import com.example.LocalGuide.entity.Guide;

public record GuideResponse(
    Long id,
    String f_name, 
    String l_name, 
    String email, 
    String city, 
    String state, 
    String bio) {
        public static GuideResponse from(Guide guide) {
            return new GuideResponse(
                guide.getId(),
                guide.getFName(),
                guide.getLName(),
                guide.getEmail(),
                guide.getCity(),
                guide.getState(),
                guide.getBio()
            );
        }
}
