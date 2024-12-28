package com.project.diplomation.data.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Recension extends BaseEntity {
    @Column(name = "date_of_submission")
    private LocalDate dateOfSubmission;
    @Column(name = "text")
    private String text;
    @Column(name = "conclusion")
    private String conclusion;
    @Column(name = "is_passed")
    private boolean isPassed;
    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private UniversityTutor reviewer;
    @OneToOne
    @NotNull
    @JoinColumn(name = "thesis_id", nullable = false)
    private Thesis thesis;
    public Recension() {}
}
