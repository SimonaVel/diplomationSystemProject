package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.ApplicationDTO;
import com.project.diplomation.data.models.dto.CreateApplicationDTO;
import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.service.ApplicationService;
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

//    @PostMapping("/create")
//    public CreateApplicationDTO createApplication(@RequestBody CreateApplicationDTO applicationDTO) {
//        return this.applicationService.createApplicationDTO(mapperUtil.getModelMapper().map(applicationDTO, Application.class));
//    }

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

//    @DeleteMapping("/delete/{id}")
//    public void deleteApplication(@PathVariable long id) {
//        this.applicationService.deleteApplication(id);
//    }
}
