package com.project.diplomation.data.models.entities;


import com.project.diplomation.data.models.enums.ApplicationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "application")
public class Application extends BaseEntity {
    private String topic;
    private String aims;
    private String problems;
    private String technologies;
    private ApplicationStatus status;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "uni_tutor_id", nullable = false)
    private UniversityTutor tutor;
    @NotNull
    @OneToOne(mappedBy = "application")
    private Thesis thesis;
    public Application() {}
}
