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
//    private final MapperUtil mapperUtil;

//    public CreateStudentDTO createStudent(Student student) {
//        return mapperUtil.getModelMapper()
//                .map(this.studentRepo
//                        .save(mapperUtil.getModelMapper()
//                                .map(student, Student.class)), CreateStudentDTO.class);
//
//    }

//    public Student createStudent(Student student) {
//        return studentRepo.save(student);
//    }
//    public StudentDTO getStudent(long id) {
//        return this.mapperUtil.getModelMapper()
//            .map(this.studentRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student with id=" + id + " not found!")),
//                    StudentDTO.class);
//    }

    public Student getStudent(long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with id=" + id + " not found!"));
    }

    public List<Student> getStudentByName(String name) {
        return studentRepo.findByName(name);
    }

    public Student getStudentByFNumber(String fNumber) {
        return studentRepo.findByfNumber(fNumber);
    }
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

}
