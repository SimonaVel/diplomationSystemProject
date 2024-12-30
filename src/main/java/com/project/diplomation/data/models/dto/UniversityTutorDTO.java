package com.project.diplomation.data.models.dto;

import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.BaseEntity;
import com.project.diplomation.data.models.entities.Recension;
import com.project.diplomation.data.models.enums.PositionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;

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
    private long id;
    private String name;
    private PositionType positionType;
//    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Recension> recensions;
//    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Application> applications;
}
