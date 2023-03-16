package com.thejan.lms.service;

import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Role;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.User;
import com.thejan.lms.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void Given_User_When_GetStudentIsCalledWithId_Then_ReturnStudent() {
        //given
        Long id = anyLong();
        User user = User.builder()
                .firstName("Test")
                .lastName("Test")
                .email("student@test.com")
                .password("password")
                .role(Role.STUDENT).build();
        Student student = new Student(user);
        //when
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        Student resultStudent = studentService.getStudent(id);

        //then
        Assertions.assertEquals(id, resultStudent.getId());
        Assertions.assertEquals("student@test.com", resultStudent.getEmail());

    }
    @Test
    public void Given_User_When_GetStudentIsCalledWithEmail_Then_Return_Student() {
        //given
        String email = "student@test.com";
        User user = User.builder()
                .firstName("Test")
                .lastName("Test")
                .email(email)
                .password("password")
                .role(Role.STUDENT).build();
        Student student = new Student(user);
        //when
        when(studentRepository.findStudentByEmail(email)).thenReturn(Optional.of(student));
        Student resultStudent = studentService.getStudent(email);

        //then
        Assertions.assertEquals(email, resultStudent.getEmail());
    }

    @Test
    public void Given_Student_When_GetEnrolledCourseIsCalledWithEmail_Then_ReturnListOfCourses() {
        //given
        String email = "student@test.com";
        User user = User.builder()
                .firstName("Test")
                .lastName("Test")
                .email(email)
                .password("password")
                .role(Role.STUDENT).build();
        Student student = new Student(user);
        //when
        when(studentRepository.findStudentByEmail(email)).thenReturn(Optional.of(student));
        List<Course> courses = studentService.getEnrolledCourses(email);
        //then
        Assertions.assertEquals(courses, student.getRegistrations().stream().toList());
    }

    @Test
    public void testGetStudents() {
        //given
        Student student1 = new Student();
        Student student2 = new Student();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        //when
        when(studentRepository.findAll()).thenReturn(students);
        List<Student> resultStudents = studentService.getStudents();

        //then
        Assertions.assertEquals(students, resultStudents);
    }

}
