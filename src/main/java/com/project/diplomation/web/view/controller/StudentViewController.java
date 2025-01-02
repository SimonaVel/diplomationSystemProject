package com.project.diplomation.web.view.controller;

import com.project.diplomation.data.models.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class StudentViewController {
    @GetMapping("/students")
    String getStudentsView(Model model) {
        model.addAttribute("something", "Hello World!");
        model.addAttribute("students", Arrays.asList(
                new Student("Ivan Ivanov", "12348", null),
                new Student("Petar Petrov", "12349", null),
                new Student("Georgi Georgiev", "123410", null)
        ));
        // returns the name of the template page(view) to be rendered
        return "students";
    }
}
