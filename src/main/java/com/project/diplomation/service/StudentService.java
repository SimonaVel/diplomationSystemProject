package com.project.diplomation.service;

import com.project.diplomation.data.models.dto.CreateStudentDTO;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.models.entities.StudentDTO;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// for StudentRepo?
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
                .orElseThrow(() -> new RuntimeException("Student with id=" + id + " not found!")),
                    StudentDTO.class);
    }

//    public Student getStudent(long id) {
//        return studentRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student with id=" + id + " not found!"));
//    }

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

}
