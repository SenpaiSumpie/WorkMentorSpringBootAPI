package com.workmentor.api.models;

import javax.persistence.*;

@Entity
@Table(name = "review_table")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String reviewee;
    private String review;
    private float rating;
    private String reviewer;

    public Review() {}

    public Review(Integer id, String reviewee, String review, float rating, String reviewer) {
        this.id = id;
        this.reviewee = reviewee;
        this.review = review;
        this.rating = rating;
        this.reviewer = reviewer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReviewee() {
        return reviewee;
    }

    public void setReviewee(String reviewee) {
        this.reviewee = reviewee;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
