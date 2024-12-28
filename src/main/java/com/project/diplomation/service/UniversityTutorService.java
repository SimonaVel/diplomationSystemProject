package com.project.diplomation.service;

import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.UniversityTutor;
import com.project.diplomation.data.models.enums.PositionType;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.data.repositories.UniversityTutorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityTutorService {
    private final UniversityTutorRepo universityTutorRepo;
    public UniversityTutor getUniversityTutor(long id) {
        return universityTutorRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("University tutor with id=" + id + " not found!"));
    }
    public List<UniversityTutor> getUniversityTutorByName(String name) {
        return universityTutorRepo.findByName(name);
    }

    public List<UniversityTutor> getUniversityTutorByPositionType(PositionType positionType) {
        return universityTutorRepo.findUniversityTutorByPositionType(positionType);
    }
    public List<UniversityTutor> getAllUniversityTutors() {
        return universityTutorRepo.findAll();
    }

}
