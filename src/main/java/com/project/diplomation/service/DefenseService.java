package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.CreateDefenseDTO;
import com.project.diplomation.data.models.dto.DefenseDTO;
import com.project.diplomation.data.models.entities.Defense;
import com.project.diplomation.data.repositories.DefenseRepo;
import com.project.diplomation.exception.DefenseNotFoundException;
import com.project.diplomation.exception.ReviewNotFoundException;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefenseService {
    private final DefenseRepo defenseRepo;
    private final MapperUtil mapperUtil;

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

}
