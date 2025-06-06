package com.project.diplomation.data.models.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ThesisDTO {
    private Long id;
    private String title;
    private String text;
    private LocalDate dateOfSubmission;
    private long applicationId;
}
