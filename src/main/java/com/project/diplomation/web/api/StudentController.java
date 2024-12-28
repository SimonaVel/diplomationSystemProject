package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.CreateStudentDTO;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.StudentDTO;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.util.MapperUtil;
import com.project.diplomation.web.view.controller.model.CreateStudentViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private MapperUtil mapperUtil;

    @PostMapping
    public CreateStudentViewModel createStudent(@RequestBody CreateStudentViewModel student) {
        return mapperUtil.getModelMapper().map(this.studentService
                        // TODO (Type) is questionable
                .createStudent(mapperUtil.getModelMapper().map(student, (Type) CreateStudentDTO.class)), CreateStudentViewModel.class);
    }

//    @PostMapping
//    public CreateStudentDTO createStudent(@RequestBody CreateStudentDTO student) {
//        return this.studentService.createStudentDTO(mapperUtil.getModelMapper().map(student, Student.class));
//    }
//
//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        return this.studentService.createStudent(student);
//    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable long id){
        return this.studentService.getStudent(id);
    }
    @GetMapping("/by-name/{name}")
    public List<StudentDTO> getStudentByName(@PathVariable String name) {
        return this.studentService.getStudentByName(name);
    }

    @GetMapping("/by-f_number/{fNumber}")
    public StudentDTO getStudentByFNumber(@PathVariable String fNumber) {
        return this.studentService.getStudentByFNumber(fNumber);
    }
    @GetMapping("/all")
    public List<StudentDTO> getAllStudents() {
        return this.studentService.getAllStudents();
    }
}
