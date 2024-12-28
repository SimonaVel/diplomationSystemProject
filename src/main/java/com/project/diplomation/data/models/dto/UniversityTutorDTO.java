package com.project.diplomation.data.models.dto;

import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.BaseEntity;
import com.project.diplomation.data.models.entities.Recension;
import com.project.diplomation.data.models.enums.PositionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;

/**
 * Represents a placeholder for the data of a university tutor.
 * Has an id, name and position type.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UniversityTutorDTO {
    private String name;
    private PositionType positionType;

//    @OneToMany(mappedBy = "reviewer")
//    private HashSet<Recension> recensions;
//    @OneToMany
//    private HashSet<Application> applications;
}
