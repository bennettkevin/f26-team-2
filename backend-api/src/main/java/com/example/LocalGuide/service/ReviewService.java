package com.example.LocalGuide.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LocalGuide.entity.Review;
import com.example.LocalGuide.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> searchReviews(Long guideTourId) {
        if (guideTourId != null) {
            return reviewRepository.findByGuideTourId(guideTourId);
        }
        else {
            return reviewRepository.findAll();
        }
    }

    public List<Review> getReviewByGuideId(Long guideId) {
        return reviewRepository.findAllByGuideIdOrderByReviewDateDescIdDesc(guideId);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Review existingReview = reviewRepository.findById(id).orElse(null);
        if (existingReview != null) {
            existingReview.setComments(updatedReview.getComments());
            existingReview.setReplyText(updatedReview.getReplyText());
            existingReview.setReviewDate(updatedReview.getReviewDate());
            existingReview.setGuide(updatedReview.getGuide());
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
    
}
