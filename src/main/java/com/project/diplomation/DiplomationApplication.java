package com.project.diplomation;

import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.data.repositories.StudentRepo;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.util.MapperUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiplomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomationApplication.class, args);
		Student student = new Student("Ivan Ivanov", "123456", null);
		System.out.println(student.getId());
		System.out.println(student);

	}

}
