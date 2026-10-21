package com.example.LocalGuide.repository;

import com.example.LocalGuide.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByCustomerIdOrderByReviewDateDescIdDesc(Long customerId);

    List<Review> findAllByGuideIdOrderByReviewDateDescIdDesc(Long guideId);
}
