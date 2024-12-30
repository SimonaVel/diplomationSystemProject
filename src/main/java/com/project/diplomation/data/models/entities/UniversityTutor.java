package com.project.diplomation.data.models.entities;

import com.project.diplomation.data.models.enums.PositionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

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

    @OneToMany(mappedBy = "reviewer")
    private HashSet<Recension> recensions;
    @OneToMany
    private HashSet<Application> applications;
}
