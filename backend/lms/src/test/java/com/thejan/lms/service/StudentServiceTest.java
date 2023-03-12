package com.thejan.lms.service;

import com.thejan.lms.entity.Role;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.User;
import com.thejan.lms.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testGetStudent() {
        //given
        String email = "teacher@test.com";
        User user = User.builder()
                .firstName("Test")
                .lastName("Test")
                .email(email)
                .password("password")
                .role(Role.TEACHER).build();
        Student student = new Student(user);
        //when
        when(studentRepository.findStudentByEmail(email)).thenReturn(Optional.of(student));
        Student resultStudent = studentService.getStudent(email);

        //then
        Assertions.assertEquals(email, resultStudent.getEmail());
    }
}
