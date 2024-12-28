package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.CreateStudentDTO;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.util.MapperUtil;
import com.project.diplomation.web.view.controller.model.CreateStudentViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private MapperUtil mapperUtil;

//    @PostMapping
//    public CreateStudentViewModel createStudent(@RequestBody CreateStudentViewModel student) {
//        return mapperUtil.getModelMapper().map(this.studentService
//                .createStudent(mapperUtil.getModelMapper().map(student, CreateStudentDTO.class)), CreateStudentViewModel.class);
//    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id){
        return this.studentService.getStudent(id);
    }
    @GetMapping("/by-name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return this.studentService.getStudentByName(name);
    }

    @GetMapping("/by-f_number/{fNumber}")
    public Student getStudentByFNumber(@PathVariable String fNumber) {
        return this.studentService.getStudentByFNumber(fNumber);
    }
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }
}
