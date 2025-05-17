package com.project.diplomation.data.models.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateReviewDTO {
    private LocalDate dateOfSubmission;
    private String text;
    private String conclusion;
    private long reviewerId;
    private long thesisId;
    private boolean isPassed;
}

