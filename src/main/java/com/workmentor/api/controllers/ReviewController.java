package com.workmentor.api.controllers;

import com.workmentor.api.models.Review;
import com.workmentor.api.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController( ReviewService reviewService ){
        this.reviewService = reviewService;
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping("/{id}")
    public Review GetReview(@PathVariable String id){
        return reviewService.GetReviewById(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping
    public List<Review> GetAllReviews(){
        return reviewService.GetAllReviews();
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PostMapping
    public Review PostReview(@RequestBody Review user){
        return reviewService.AddNewReview(user);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PutMapping
    public ResponseEntity<Review> PutReview(@RequestBody Review review){
        Review foundReview = reviewService.GetReviewById(review.getId().toString());
        if(foundReview != null){
            Review updatedReview = reviewService.UpdateReview(review);
            return new ResponseEntity<>(updatedReview, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteReview(@RequestBody Review review){
        Review foundReview = reviewService.GetReviewById(review.getId().toString());
        if(foundReview != null){
            reviewService.DeleteReview(review);
            return new ResponseEntity<>("Deleted User", HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
