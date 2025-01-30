package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.ApplicationDTO;
import com.project.diplomation.data.models.dto.CreateApplicationDTO;
import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.UniversityTutor;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.data.repositories.UniversityTutorRepo;
import com.project.diplomation.service.ApplicationService;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.service.UniversityTutorService;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final MapperUtil mapperUtil;
    private final StudentRepo studentRepo;
    private final UniversityTutorRepo tutorRepo;

    @PostMapping("/create")
    public CreateApplicationDTO createApplication(@RequestBody CreateApplicationDTO applicationDTO) {
        Student student = studentRepo.getById(applicationDTO.getStudentId());
        UniversityTutor tutor = tutorRepo.getById(applicationDTO.getTutorId());

        // Create a new Application entity with the fetched foreign keys
        Application application = new Application();
        application.setTopic(applicationDTO.getTopic());
        application.setAims(applicationDTO.getAims());
        application.setProblems(applicationDTO.getProblems());
        application.setTechnologies(applicationDTO.getTechnologies());
        application.setStatus(applicationDTO.getStatus());
        application.setStudent(student);
        application.setTutor(tutor);

        // Save the application in the database
        CreateApplicationDTO savedApplication = applicationService.createApplicationDTO(application);

        // Convert and return response as DTO
        return savedApplication;
    }

    @GetMapping("/{id}")
    public ApplicationDTO getApplication(@PathVariable long id){
        return this.applicationService.getApplication(id);
    }

    @GetMapping("/by-student/{studentId}")
    public List<ApplicationDTO> getApplicationsByStudent(@PathVariable long studentId) {
        return this.applicationService.getApplicationByStudentId(studentId);
    }

    @GetMapping("/all")
    public List<ApplicationDTO> getAllApplications() {
        return this.applicationService.getAllApplications();
    }

//    @PutMapping("/update/{id}")
//    public void updateApplication(@PathVariable long id, @RequestBody Application application) {
//        this.applicationService.updateApplication(application, id);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteApplication(@PathVariable long id) {
        this.applicationService.deleteApplication(id);
    }
}
