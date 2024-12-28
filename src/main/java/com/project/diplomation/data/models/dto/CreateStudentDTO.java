package com.project.diplomation.data.models.dto;

import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.BaseEntity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;

/**
 * Represents the data of a student.
 * Has an id, name and faculty number.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStudentDTO {
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "[0-9]{5,6}", message = "Faculty numbers should consist of 5 or 6 consecutive numbers!")
    private String fNumber;
}

