package com.project.diplomation.data.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.constraints.Size;

import java.util.HashSet;

/**
 * Represents a student entity.
 * Has an id, name and faculty number.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student")
public class Student extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "f_number", unique = true)
    @Pattern(regexp = "[0-9]{5,6}", message = "Faculty numbers should consist of 5 or 6 consecutive numbers!")
    private String fNumber;

    @OneToMany(mappedBy = "student")
    private HashSet<Application> applications;
}
