package com.project.diplomation.web.view.controller;

import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.StudentDTO;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.util.MapperUtil;
import com.project.diplomation.web.api.StudentController;
import com.project.diplomation.web.view.model.StudentViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentViewController {
    private final MapperUtil mapperUtil;
    private final StudentService studentService;

    @GetMapping
    String getStudentsView(Model model) {
        List<StudentViewModel> students = mapperUtil
                .mapList(this.studentService.getAllStudents(), StudentViewModel.class);
        model.addAttribute("students", students);
        // returns the name of the template page(view) to be rendered
        return "students";
    }
}
