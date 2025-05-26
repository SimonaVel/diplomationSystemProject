package com.project.diplomation.data.repositories;

import com.project.diplomation.data.models.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReviewRepoTest {
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private TestEntityManager entityManager;
    @Test
    void countUniqueStudentsWithFailedReviews() {
        // preconditions
        Long resultBeforeUpdate = reviewRepo.countUniqueStudentsWithFailedReviews();
        Student student = Student.builder()
                .name("John Doe")
                .fNumber("123456")
                .build();
        entityManager.persist(student);

        UniversityTutor supervisor = UniversityTutor.builder()
                .name("Rukovoditel")
                .build();
        entityManager.persist(supervisor);


        UniversityTutor reviewer = UniversityTutor.builder()
                .name("Reviewer")
                .build();
        entityManager.persist(reviewer);

        Application application = Application.builder()
                .student(student)
                .tutor(supervisor)
                .build();
        entityManager.persist(application);

        Thesis thesis = Thesis.builder()
                .application(application)
                .build();
        entityManager.persist(thesis);

        Review review = Review.builder()
                .reviewer(reviewer)
                .thesis(thesis)
                .isPassed(false)
                .build();
        entityManager.persist(review);

        // Rollback changes so that base stays intact
        entityManager.flush();

        // action
        Long result = reviewRepo.countUniqueStudentsWithFailedReviews();

        // assert
        assertEquals(resultBeforeUpdate + 1, result);
    }
}