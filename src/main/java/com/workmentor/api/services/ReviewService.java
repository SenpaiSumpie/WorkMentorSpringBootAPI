package com.workmentor.api.services;

import com.workmentor.api.models.Review;
import com.workmentor.api.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService( ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Review AddNewReview(Review review){
        return reviewRepository.save(review);
    }

    public List<Review> GetAllReviews(){
        return reviewRepository.findAll();
    }

    public Review GetReviewById(String id){
        return reviewRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public Review UpdateReview(Review review){
        return reviewRepository.save(review);
    }

    public boolean DeleteReview(Review review){
        reviewRepository.delete(review);
        return true;
    }
}
