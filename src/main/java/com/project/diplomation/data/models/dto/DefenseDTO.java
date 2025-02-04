package com.project.diplomation.data.models.dto;

import com.project.diplomation.data.models.entities.Review;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DefenseDTO {
    private long id;
    private LocalDate date;
    private int grade;
    private long review_id;
}

