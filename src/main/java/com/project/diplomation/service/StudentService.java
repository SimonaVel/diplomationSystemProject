package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.CreateStudentDTO;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.StudentDTO;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.exception.StudentNotFoundException;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final MapperUtil mapperUtil;

    public CreateStudentDTO createStudentDTO(Student student) {
        return mapperUtil.getModelMapper()
                .map(this.studentRepo
                        .save(mapperUtil.getModelMapper()
                                .map(student, Student.class)), CreateStudentDTO.class);

    }

    public StudentDTO getStudent(long id) {
        return this.mapperUtil.getModelMapper()
            .map(this.studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id=" + id + " not found!")),
                    StudentDTO.class);
    }



    public List<StudentDTO> getStudentByName(String name) {
        return this.mapperUtil
                .mapList(
                        this.studentRepo.findByName(name), StudentDTO.class);
    }

    public StudentDTO getStudentByFNumber(String fNumber) {
        return this.mapperUtil.getModelMapper()
                .map(this.studentRepo.findByfNumber(fNumber), StudentDTO.class);
    }
    public List<StudentDTO> getAllStudents() {
        return this.mapperUtil
                .mapList(
                        this.studentRepo.findAll(), StudentDTO.class);
    }

    public Student updateStudent(Student student, long id) {
//        student == json Entity
//        student1 == db Entity
//        if student1.field == null, then student.field = student.field
        return this.studentRepo.findById(id)
            .map(student1 -> {
                student1.setName(student.getName() == null ? student1.getName() : student.getName());
                student1.setFNumber(student.getFNumber() == null ? student1.getFNumber() : student.getFNumber());
                return this.studentRepo.save(student1);
            })
//                // if the student with the given id is not found, throw an exception
                .orElseThrow(() -> new StudentNotFoundException("Student with id= " + id + " not found!"));
//                // if the student with the given id is not found, create a new student
//                .orElseGet(() -> this.studentRepo.save(student));
    }

    public void deleteStudent(long id) {
        this.studentRepo.deleteById(id);
    }
}
