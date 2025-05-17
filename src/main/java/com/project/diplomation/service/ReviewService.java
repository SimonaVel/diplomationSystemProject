package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.CreateReviewDTO;
import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.data.repositories.ReviewRepo;
import com.project.diplomation.exception.ReviewNotFoundException;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final MapperUtil mapperUtil;

    public CreateReviewDTO createReviewDTO(Review review) {
        return mapperUtil.getModelMapper()
                .map(this.reviewRepo
                        .save(mapperUtil.getModelMapper()
                                .map(review, Review.class)), CreateReviewDTO.class);

    }

    public ReviewDTO getReview(long id) {
        Optional<Review> review = reviewRepo.findById(id);
        return new ReviewDTO(
                review.get().getId(),
                review.get().getDateOfSubmission(),
                review.get().getText(),
                review.get().getConclusion(),
                review.get().getReviewer().getId(),
                review.get().getThesis().getId(),
                review.get().isPassed());
    }

    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = this.reviewRepo.findAll();
        ReviewDTO reviewDTO = new ReviewDTO();
        List<ReviewDTO> reviewDTOS = new ArrayList<>();
        for (Review review : reviews) {
            reviewDTOS.add(reviewDTO.mapReviewToDTO(review));
        }
        return reviewDTOS;
    }

    public void deleteReview(long id) {
        try {
            this.reviewRepo.deleteById(id);
        } catch (Exception e) {
            throw new ReviewNotFoundException("Review with id=" + id + " could not be deleted!");
        }
    }

    public ReviewDTO getReviewByThesisId(long id) {
        return this.mapperUtil.getModelMapper()
                .map(this.reviewRepo.findReviewByThesis_Id(id), ReviewDTO.class);
    }
}
