package com.project.diplomation.data.models.entities;

import jakarta.persistence.*;
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
@Table(name = "thesis")
public class Thesis extends BaseEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;
    @Column(name = "date_of_submission")
    private LocalDate dateOfSubmission;
    @OneToOne(cascade = CascadeType.ALL)
    private Application application;

    @OneToOne(mappedBy = "thesis")
    private Review review;

    public Thesis() {}
}
