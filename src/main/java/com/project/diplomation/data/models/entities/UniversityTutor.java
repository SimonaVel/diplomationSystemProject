package com.project.diplomation.data.models.entities;

import com.project.diplomation.data.models.enums.PositionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;

/**
 * Represents a university tutor entity.
 * Has an id, name and position type.
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="uni_tutor")
public class UniversityTutor extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "position_type")
    private PositionType positionType;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Recension> recensions;
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Application> applications;
}
