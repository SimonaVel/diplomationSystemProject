package com.project.diplomation.web.view.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateReviewViewModel {
    private LocalDate dateOfSubmission;
    private String text;
    private String conclusion;
    private long reviewer_id;
    private long thesis_id;
    private boolean isPassed;
}

