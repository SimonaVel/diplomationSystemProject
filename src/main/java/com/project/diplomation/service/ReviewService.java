package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.ApplicationDTO;
import com.project.diplomation.data.models.dto.CreateApplicationDTO;
import com.project.diplomation.data.models.dto.CreateReviewDTO;
import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.data.repositories.ApplicationRepo;
import com.project.diplomation.data.repositories.ReviewRepo;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.data.repositories.UniversityTutorRepo;
import com.project.diplomation.exception.ReviewNotFoundException;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.mapperUtil.getModelMapper()
            .map(this.reviewRepo.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review with id=" + id + " not found!")),
                    ReviewDTO.class);
    }


    public List<ReviewDTO> getAllReviews() {
        return this.mapperUtil
                .mapList(
                        this.reviewRepo.findAll(), ReviewDTO.class);
    }

    public void deleteReview(long id) {
        try {
            this.reviewRepo.deleteById(id);
        } catch (Exception e) {
            throw new ReviewNotFoundException("Review with id=" + id + " could not be deleted!");
        }
    }

}
