package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.ApplicationDTO;
import com.project.diplomation.data.models.dto.CreateApplicationDTO;
import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.repositories.ApplicationRepo;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepo applicationRepo;
    private final MapperUtil mapperUtil;

    public CreateApplicationDTO createApplicationDTO(Application application) {
        return mapperUtil.getModelMapper()
                .map(this.applicationRepo
                        .save(mapperUtil.getModelMapper()
                                .map(application, Application.class)), CreateApplicationDTO.class);

    }

    public ApplicationDTO getApplication(long id) {
        return this.mapperUtil.getModelMapper()
            .map(this.applicationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application with id=" + id + " not found!")),
                    ApplicationDTO.class);
    }

    public List<ApplicationDTO> getApplicationByStudentId(long studentId) {
        return this.mapperUtil
                .mapList(
                        this.applicationRepo.findByStudentId(studentId), ApplicationDTO.class);
    }

    public List<ApplicationDTO> getAllApplications() {
        return this.mapperUtil
                .mapList(
                        this.applicationRepo.findAll(), ApplicationDTO.class);
    }

//    public void updateApplication(Application application, long id) {
//        Application applicationToUpdate = this.applicationRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Application with id= " + id + " not found!"));
//        applicationToUpdate.setStudentId(application.getStudentId());
//        applicationToUpdate.setApplicationDate(application.getApplicationDate());
//        applicationToUpdate.setApplicationStatus(application.getApplicationStatus());
//        this.applicationRepo.save(applicationToUpdate);
//    }

//    public void deleteApplication(long id) {
//        this.applicationRepo.deleteById(id);
//    }
}
