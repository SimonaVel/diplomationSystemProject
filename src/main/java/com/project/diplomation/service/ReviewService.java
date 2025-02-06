package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.ApplicationDTO;
import com.project.diplomation.data.models.dto.CreateApplicationDTO;
import com.project.diplomation.data.models.dto.CreateReviewDTO;
import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.data.repositories.ApplicationRepo;
import com.project.diplomation.data.repositories.ReviewRepo;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.data.repositories.UniversityTutorRepo;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final MapperUtil mapperUtil;

    public CreateReviewDTO createReviewDTO(Review review) {
        return mapperUtil.getModelMapper()
                .map(this.reviewRepo
                        .save(mapperUtil.getModelMapper()
                                .map(review, Review.class)), CreateReviewDTO.class);

    }

    public ReviewDTO getReview(long id) {
        return this.mapperUtil.getModelMapper()
            .map(this.reviewRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Review with id=" + id + " not found!")),
                    ReviewDTO.class);
    }


    public List<ReviewDTO> getAllReviews() {
        return this.mapperUtil
                .mapList(
                        this.reviewRepo.findAll(), ReviewDTO.class);
    }
//
//    public ApplicationDTO updateApplication(ApplicationDTO applicationDTO, long id) {
////        applicationDTO == json object
////        application == entity from db
//        return this.applicationRepo.findById(id)
//                .map(application -> {
//                    application.setTopic(applicationDTO.getTopic() == null ? application.getTopic() : applicationDTO.getTopic());
//                    application.setAims(applicationDTO.getAims() == null ? application.getAims() : applicationDTO.getAims());
//                    application.setProblems(applicationDTO.getProblems() == null ? application.getProblems() : applicationDTO.getProblems());
//                    application.setTechnologies(applicationDTO.getTechnologies() == null ? application.getTechnologies() : applicationDTO.getTechnologies());
//                    application.setStatus(applicationDTO.getStatus() == null ? application.getStatus() : applicationDTO.getStatus());
//                    application.setStudent(applicationDTO.getStudentId() == 0 ? application.getStudent() : studentRepo.getById(applicationDTO.getStudentId()));
//                    application.setTutor(applicationDTO.getTutorId() == 0 ? application.getTutor() : tutorRepo.getById(applicationDTO.getTutorId()));
//
//                    return mapperUtil.getModelMapper()
//                            .map(this.applicationRepo.save(application), ApplicationDTO.class);
//                })
//                .orElseThrow(() -> new RuntimeException("Application with id=" + id + " not found!"));
//    }

    public void deleteReview(long id) {
        this.reviewRepo.deleteById(id);
    }

}
