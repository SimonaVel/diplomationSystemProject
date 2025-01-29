package com.project.diplomation.web.view.controller;

import com.project.diplomation.data.models.dto.UniversityTutorDTO;
import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.StudentDTO;
import com.project.diplomation.data.models.enums.ApplicationStatus;
import com.project.diplomation.data.models.enums.PositionType;
import com.project.diplomation.service.ApplicationService;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.service.UniversityTutorService;
import com.project.diplomation.util.MapperUtil;
import com.project.diplomation.web.view.model.ApplicationViewModel;
import com.project.diplomation.web.view.model.CreateApplicationViewModel;
import com.project.diplomation.web.view.model.CreateStudentViewModel;
import com.project.diplomation.web.view.model.StudentViewModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/applications")
public class ApplicationViewController {
    private final MapperUtil mapperUtil;
    private final ApplicationService applicationService;
    private final StudentService studentService;
    private final UniversityTutorService universityTutorService;

    @GetMapping("/view/{id}")
    public String getApplicationView(Model model, @PathVariable long id) {
        ApplicationViewModel application = mapperUtil
                .getModelMapper()
                .map(this.applicationService.getApplication(id), ApplicationViewModel.class);
        // !!! application is a keyword in Thymeleaf
        model.addAttribute("appl", application);

        return "applications/view";
    }

    @GetMapping
    String getApplicationsView(Model model) {
        List<ApplicationViewModel> applications = mapperUtil
                .mapList(this.applicationService.getAllApplications(), ApplicationViewModel.class);
        model.addAttribute("applications", applications);
        // returns the name of the template page(view) to be rendered
        return "applications/applications";
    }
//    @GetMapping("/delete/{id}")
//    public String deleteStudent(@PathVariable long id) {
//        this.studentService.deleteStudent(id);
//        return "redirect:/students";
//    }
//    @GetMapping("/edit/{id}")
//    public String showEditStudentForm(Model model, @PathVariable Long id) {
//        model.addAttribute("student", this.studentService.getStudent(id));
//        return "/students/edit";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateStudent(@PathVariable long id, Student student) {
//        this.studentService.updateStudent(student, id);
//        return "redirect:/students";
//    }
    @GetMapping("/create")
    public String showCreateStudentForm(Model model) {
        model.addAttribute("appl", new Application());
        List<ApplicationStatus> statuses = Arrays.asList(ApplicationStatus.values());
        model.addAttribute("statuses", statuses);
        List<Long> studentIds = studentService.getAllStudents()
                .stream()
                .map(StudentDTO::getId)
                .toList();
        model.addAttribute("studentIds", studentIds);
        List<Long> tutorIds = universityTutorService.getAllUniversityTutors()
                .stream()
                .map(UniversityTutorDTO::getId)
                .toList();
        model.addAttribute("tutorIds", tutorIds);
        return "/applications/create";
    }
    @PostMapping("/save")
    public String createApplication(@Valid @ModelAttribute("appl")CreateApplicationViewModel appl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/applications/create";
        }
        this.applicationService
                .createApplicationDTO(mapperUtil.getModelMapper().map(appl, Application.class));
        return "redirect:/applications";
    }
}
