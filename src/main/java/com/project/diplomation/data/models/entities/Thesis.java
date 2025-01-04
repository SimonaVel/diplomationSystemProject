package com.project.diplomation.data.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @Column(name = "text")
    private String text;
    @Column(name = "date_of_submission")
    private LocalDate dateOfSubmission;

    @OneToOne
    private Application application;

    @OneToOne(mappedBy = "thesis")
    private Defense defense;

    @OneToOne(mappedBy = "thesis")
    private Recension recension;

    public Thesis() {}
}
