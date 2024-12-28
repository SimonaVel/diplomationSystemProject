package com.project.diplomation.data.models.entities;

import com.project.diplomation.data.models.enums.PositionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTutorTest {
    UniversityTutor universityTutor;
    @BeforeEach
    void testSetUp() {
        universityTutor = new UniversityTutor("John Doe", PositionType.ASSISTANT, null, null);
    }
    @Test
    void testGetName() {
        assertEquals("John Doe", universityTutor.getName());
    }
    @Test
    void testWrongGetName() {
        assertFalse("John Doe2".equals(universityTutor.getName()));
    }

    @Test
    void getPositionType() {
        assertEquals(PositionType.ASSISTANT, universityTutor.getPositionType());
    }

    @Test
    void testWrongGetPositionType() {
        assertFalse(PositionType.PROFESSOR.equals(universityTutor.getPositionType()));
    }

    @Test
    void testSetName() {
        universityTutor.setName("Jane Doe");
        assertEquals("Jane Doe", universityTutor.getName());
    }

    @Test
    void testWrongSetName() {
        universityTutor.setName("Jane Doe");
        assertFalse("John Doe".equals(universityTutor.getName()));
    }

    @Test
    void setPositionType() {
        universityTutor.setPositionType(PositionType.PROFESSOR);
        assertEquals(PositionType.PROFESSOR, universityTutor.getPositionType());
    }

    @Test
    void testWrongSetPositionType() {
        universityTutor.setPositionType(PositionType.PROFESSOR);
        assertFalse(PositionType.ASSISTANT.equals(universityTutor.getPositionType()));
    }

    @Test
    void testToString() {
        assertEquals(("UniversityTutor(name=" + universityTutor.getName() +
                ", positionType=" + universityTutor.getPositionType() + ")"), universityTutor.toString());
    }
}