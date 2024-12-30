package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.CreateStudentDTO;
import com.project.diplomation.data.models.dto.CreateUniversityTutorDTO;
import com.project.diplomation.data.models.dto.UniversityTutorDTO;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.UniversityTutor;
import com.project.diplomation.data.models.enums.PositionType;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.service.UniversityTutorService;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/uni-tutors")
public class UniversityTutorController {
    private final UniversityTutorService universityTutorService;
    private final MapperUtil mapperUtil;

    @PostMapping("/create")
    public CreateUniversityTutorDTO createUniversityTutorDTO(@RequestBody CreateUniversityTutorDTO universityTutorDTO) {
        return this.universityTutorService.createUniversityTutorDTO(mapperUtil.getModelMapper().map(universityTutorDTO, UniversityTutor.class));
    }
    @GetMapping("/{id}")
    public UniversityTutorDTO getUniTutor(@PathVariable long id){
        return this.universityTutorService.getUniversityTutor(id);
    }
    @GetMapping("/by-name/{name}")
    public List<UniversityTutorDTO> getUniTutorByName(@PathVariable String name) {
        return this.universityTutorService.getUniversityTutorByName(name);
    }
    @GetMapping("/by-position_type/{positionType}")
    public List<UniversityTutorDTO> getUniTutorsByPositionType(@PathVariable PositionType positionType) {
        return this.universityTutorService.getUniversityTutorByPositionType(positionType);
    }
    @GetMapping("/all")
    public List<UniversityTutorDTO> getAllUniversityTutors() {
        return this.universityTutorService.getAllUniversityTutors();
    }
}
