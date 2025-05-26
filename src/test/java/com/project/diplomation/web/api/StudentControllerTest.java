package com.project.diplomation.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.diplomation.data.models.dto.CreateStudentDTO;
import com.project.diplomation.data.models.dto.StudentDTO;
import com.project.diplomation.data.models.entities.Student;
import com.project.diplomation.service.StudentService;
import com.project.diplomation.util.MapperUtil;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private MapperUtil mapperUtil;
    @MockitoBean
    private ModelMapper modelMapper;

    private Student student;
    private StudentDTO studentDTO;
    private CreateStudentDTO createStudentDTO;

    private List<Student> students = new ArrayList<>();
    private List<StudentDTO> studentsDTO = new ArrayList<>();


    @BeforeEach
    void setUp() {
        student = Student.builder()
                .name("John Doe")
                .fNumber("123456")
                .build();

        studentDTO = StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .fNumber(student.getFNumber())
                .build();

        createStudentDTO = CreateStudentDTO.builder()
                .name(student.getName())
                .fNumber(student.getFNumber())
                .build();

        students.add(student);
        studentsDTO.add(studentDTO);
    }

    @Test
    @Order(1)
    void createStudent() throws Exception {
        // preconditions
        when(mapperUtil.getModelMapper()).thenReturn(modelMapper);
        when(modelMapper.map(any(CreateStudentDTO.class), eq(Student.class))).thenReturn(student);
        when(studentService.createStudentDTO(student)).thenReturn(createStudentDTO);

        // action + verify
        mockMvc.perform(post("/students/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createStudentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(student.getName()))
                .andExpect(jsonPath("$.fnumber").value(student.getFNumber()));
    }

    @Test
    @Order(2)
    void getStudent() throws Exception {
        // preconditions
        when(studentService.getStudent(student.getId())).thenReturn(studentDTO);
        // action + verify
        mockMvc.perform(get("/students/{id}", student.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.name").value(student.getName()))
                .andExpect(jsonPath("$.fnumber").value(student.getFNumber()));
    }

    @Test()
    @Order(3)
    // TODO: to be modified for the whole list in the future
    void getStudentByName() throws Exception {
        // preconditions
        when(studentService.getStudentByName(student.getName())).thenReturn(studentsDTO);
        // action + verify
        mockMvc.perform(get("/students/by-name/{name}", student.getName())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(student.getId()))
                .andExpect(jsonPath("$[0].name").value(student.getName()))
                .andExpect(jsonPath("$[0].fnumber").value(student.getFNumber()));
    }

    @Test
    @Order(4)
    void getStudentByFNumber() throws Exception {
        // preconditions
        when(studentService.getStudentByFNumber(student.getFNumber())).thenReturn(studentDTO);
        // action + verify
        mockMvc.perform(get("/students/by-f_number/{fNumber}", student.getFNumber())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.name").value(student.getName()))
                .andExpect(jsonPath("$.fnumber").value(student.getFNumber()));
    }

    @Test
    @Order(5)
    void getAllStudents() throws Exception {
        // precondition
        studentsDTO.add(StudentDTO.builder().name("Sam Smith").fNumber("654321").build());
        when(studentService.getAllStudents()).thenReturn(studentsDTO);

        // action
        ResultActions response = mockMvc.perform(get("/students/all"));

        // verify
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(studentsDTO.size())));
    }

    @Test
    @Order(6)
    @Rollback
    void updateStudent() throws Exception {
        // precondition
        student.setName("Updated name");
        student.setFNumber(null); // Simulate updating only the name

        when(studentService.updateStudent(any(Student.class), eq(student.getId()))).thenReturn(student);

        // action
        ResultActions response = mockMvc.perform(put("/students/update/{id}", student.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)));

        // verify
        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Order(7)
    @Rollback
    void deleteStudent() throws Exception {
        // precondition
        willDoNothing().given(studentService).deleteStudent(student.getId());

        // action
        ResultActions response = mockMvc.perform(delete("/students/{id}", student.getId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }
}