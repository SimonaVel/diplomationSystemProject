package com.project.diplomation.web.api;

import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.UniversityTutor;
import com.project.diplomation.data.models.enums.PositionType;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.service.UniversityTutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/uni-tutors")
public class UniversityTutorController {
    private final UniversityTutorService universityTutorService;

    @GetMapping("/{id}")
    public UniversityTutor getUniTutor(@PathVariable long id){
        return this.universityTutorService.getUniversityTutor(id);
    }
    @GetMapping("/by-name/{name}")
    public List<UniversityTutor> getUniTutorByName(@PathVariable String name) {
        return this.universityTutorService.getUniversityTutorByName(name);
    }
    @GetMapping("/by-position_type/{positionType}")
    public List<UniversityTutor> getUniTutorsByPositionType(@PathVariable PositionType positionType) {
        return this.universityTutorService.getUniversityTutorByPositionType(positionType);
    }
    @GetMapping("/all")
    public List<UniversityTutor> getAllUniversityTutors() {
        return this.universityTutorService.getAllUniversityTutors();
    }
}
