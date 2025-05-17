package com.project.diplomation.data.models.dto;

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

