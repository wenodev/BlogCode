package com.example.simsim.api;

import com.example.simsim.entity.Review;
import com.example.simsim.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity getAllReviews(){
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity(reviews, HttpStatus.OK);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity getReviewById(@PathVariable Long id){
        Review review = reviewService.getReviewById(id);
        return new ResponseEntity(review, HttpStatus.OK);
    }

    @PostMapping("/reviews/{productId}")
    public ResponseEntity addReviews(@RequestBody Review review, @PathVariable Long productId){
        reviewService.saveReviews(review, productId);
        return new ResponseEntity(HttpStatus.CREATED);
    }






}
