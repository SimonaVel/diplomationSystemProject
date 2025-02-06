package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.CreateDefenseDTO;
import com.project.diplomation.data.models.dto.DefenseDTO;
import com.project.diplomation.data.models.entities.Defense;
import com.project.diplomation.data.repositories.DefenseRepo;
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
//                .orElseThrow(() -> new RuntimeException("Defense with id=" + id + " not found!")),
                    ,DefenseDTO.class);
    }


    public List<DefenseDTO> getAllDefenses() {
        return this.mapperUtil
                .mapList(
                        this.defenseRepo.findAll(), DefenseDTO.class);
    }

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

    public void deleteDefense(long id) {
        this.defenseRepo.deleteById(id);
    }

}
