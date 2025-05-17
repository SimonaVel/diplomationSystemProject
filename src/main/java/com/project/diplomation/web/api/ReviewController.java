package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.exception.ReviewNotFoundException;
import com.project.diplomation.service.ReviewService;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final MapperUtil mapperUtil;

//    @PostMapping("/create")
//    public CreateReviewDTO createReview(@RequestBody CreateReviewDTO reviewDTO) {
//        return this.reviewService.createReviewDTO(mapperUtil.getModelMapper().map(reviewDTO, Review.class));
//    }

    @GetMapping("/{id}")
    public ReviewDTO getReview(@PathVariable long id){
        try {
            return this.reviewService.getReview(id);
        } catch (ReviewNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found", exception);
        }
    }

    @GetMapping("/all")
    public List<ReviewDTO> getAllReviews() {
        return this.reviewService.getAllReviews();
    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteReview(@PathVariable long id) {
//        try {
//            this.reviewService.deleteReview(id);
//        } catch (ReviewNotFoundException exception) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Review to be deleted Not Found", exception);
//        }
//    }

//    @GetMapping("/by-thesis-id/{id}")
//    public ReviewDTO getReviewByThesisId(@PathVariable long id) {
//        return this.reviewService.getReviewByThesisId(id);
//    }
}
