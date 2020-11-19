package com.example.simsim.service;

import com.example.simsim.entity.Product;
import com.example.simsim.entity.ProductRepository;
import com.example.simsim.entity.Review;
import com.example.simsim.entity.ReviewRepository;
import com.example.simsim.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    @Transactional
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @Transactional
    public Review getReviewById(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no " + id + " in Review"));
        return review;
    }

    @Transactional
    public void saveReviews(Review review, Long productId){

        Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("no " + productId + " in Product"));
        review.setProduct(product);

        reviewRepository.save(review);
    }








}
