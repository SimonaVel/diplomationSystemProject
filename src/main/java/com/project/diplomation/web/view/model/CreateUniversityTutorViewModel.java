package com.project.diplomation.web.view.model;

import com.project.diplomation.data.models.enums.PositionType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 * Represents the data of a uniTutor.
 * Has a name and position type.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUniversityTutorViewModel {
    private String name;
    private PositionType positionType;
}

