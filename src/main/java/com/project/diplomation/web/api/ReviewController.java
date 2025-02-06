package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.CreateReviewDTO;
import com.project.diplomation.data.models.dto.CreateStudentDTO;
import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.StudentDTO;
import com.project.diplomation.service.ReviewService;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final MapperUtil mapperUtil;

    @PostMapping("/create")
    public CreateReviewDTO createReview(@RequestBody CreateReviewDTO reviewDTO) {
        return this.reviewService.createReviewDTO(mapperUtil.getModelMapper().map(reviewDTO, Review.class));
    }

    @GetMapping("/{id}")
    public ReviewDTO getReview(@PathVariable long id){
        return this.reviewService.getReview(id);
    }

    @GetMapping("/all")
    public List<ReviewDTO> getAllReviews() {
        return this.reviewService.getAllReviews();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable long id) {
        this.reviewService.deleteReview(id);
    }
}
