package com.project.diplomation.data.models.dto;

import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.data.models.entities.Thesis;
import com.project.diplomation.data.models.entities.UniversityTutor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDTO {
    private long id;
    private LocalDate dateOfSubmission;
    private String text;
    private String conclusion;
    private long reviewer_id;
    private long thesis_id;
    private boolean isPassed;

    public ReviewDTO mapReviewToDTO (Review review) {
        ReviewDTO reviewDTO = new ReviewDTO(
                review.getId(),
                review.getDateOfSubmission(),
                review.getText(),
                review.getConclusion(),
                review.getReviewer().getId(),
                review.getThesis().getId(),
                review.isPassed());
        return reviewDTO;
    }

}

