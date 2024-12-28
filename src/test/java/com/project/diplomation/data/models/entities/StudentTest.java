package com.project.diplomation.data.models.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    @BeforeEach
    void testSetUp() {
        student = new Student("John Doe", "123456");
    }
    @Test
    void testStudentCorrectFNumber() {
        assertEquals("123456", student.getFNumber());
    }
    @Test
    void testStudentIncorrectFNumber() {
        assertFalse("123457".equals(student.getFNumber()));
    }
}