package com.project.diplomation.data.repositories;

import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.UniversityTutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findByReviewer(UniversityTutor reviewer);
    Review findByDateOfSubmission(LocalDate date);
}
