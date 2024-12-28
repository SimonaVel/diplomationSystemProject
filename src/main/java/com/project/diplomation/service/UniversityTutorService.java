package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.UniversityTutorDTO;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.UniversityTutor;
import com.project.diplomation.data.models.enums.PositionType;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.data.repositories.UniversityTutorRepo;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityTutorService {
    private final UniversityTutorRepo universityTutorRepo;
    private final MapperUtil mapperUtil;
    public UniversityTutorDTO getUniversityTutor(long id) {
        return this.mapperUtil.getModelMapper()
                .map(this.universityTutorRepo.findById(id)
                                .orElseThrow(() -> new RuntimeException("University tutor with id=" + id + " not found!")),
                        UniversityTutorDTO.class);
    }
    public List<UniversityTutorDTO> getUniversityTutorByName(String name) {
        return this.mapperUtil
                .mapList(this.universityTutorRepo.findByName(name)
                        , UniversityTutorDTO.class);
    }

    public List<UniversityTutorDTO> getUniversityTutorByPositionType(PositionType positionType) {
        return this.mapperUtil
                .mapList(this.universityTutorRepo.findUniversityTutorByPositionType(positionType)
                        , UniversityTutorDTO.class);
    }
    public List<UniversityTutorDTO> getAllUniversityTutors() {
        return this.mapperUtil
                .mapList(this.universityTutorRepo.findAll()
                        , UniversityTutorDTO.class);
    }

}
