package com.project.diplomation.data.repositories;

import com.project.diplomation.data.models.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
    List<Application> findByStudentId(long studentId);
}
