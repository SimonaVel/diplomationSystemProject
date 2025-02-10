package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.CreateDefenseDTO;
import com.project.diplomation.data.models.dto.DefenseDTO;
import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.data.models.entities.Defense;
import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.data.repositories.DefenseRepo;
import com.project.diplomation.data.repositories.ReviewRepo;
import com.project.diplomation.exception.DefenseNotFoundException;
import com.project.diplomation.exception.ReviewNotFoundException;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefenseService {
    private final DefenseRepo defenseRepo;
    private final MapperUtil mapperUtil;
    private final ReviewService reviewService;

    public CreateDefenseDTO createReviewDTO(Defense defense) {
        return mapperUtil.getModelMapper()
                .map(this.defenseRepo
                        .save(mapperUtil.getModelMapper()
                                .map(defense, Defense.class)), CreateDefenseDTO.class);

    }

    public DefenseDTO getDefense(long id) {
            return this.mapperUtil.getModelMapper()
                    .map(this.defenseRepo.findById(id)
//                            .orElseThrow(() -> new DefenseNotFoundException("Defense with id=" + id + " not found!"))
                            , DefenseDTO.class);

    }

    public List<DefenseDTO> getAllDefenses() {
        return this.mapperUtil
                .mapList(
                        this.defenseRepo.findAll(), DefenseDTO.class);
    }

    public void deleteDefense(long id) {
        try {
        this.defenseRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Defense with id=" + id + " could not be deleted!");
        }
    }

    public List<DefenseDTO> getDefenseByGradeBetween(int min, int max) {
        return this.mapperUtil
                .mapList(
                        this.defenseRepo.findDefenseByGradeBetween(min, max), DefenseDTO.class);
    }

    public DefenseDTO getDefenseByReviewId(long reviewId) {
        return this.mapperUtil.getModelMapper()
                .map(this.defenseRepo.findDefenseByReview_Id(reviewId), DefenseDTO.class);
    }

    public List<DefenseDTO> getDefensesByDateBetween(LocalDate startDate, LocalDate endDate) {
        return this.mapperUtil
                .mapList(
                        this.defenseRepo.findDefenseByDateBetween(startDate, endDate), DefenseDTO.class);
    }

    public List<DefenseDTO> getDefenseByDateBetweenAndGradeBetween(LocalDate startDate, LocalDate endDate, int min, int max) {
        return this.mapperUtil
                .mapList(
                        this.defenseRepo.findDefenseByDateBetweenAndAndGradeBetween(startDate, endDate, min, max), DefenseDTO.class);
    }
}
