package com.thejan.lms;

import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Role;
import com.thejan.lms.service.AuthenticationService;
import com.thejan.lms.service.CourseService;
import com.thejan.lms.dto.RegisterRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class SampleData {
    private final AuthenticationService authenticationService;
    private final CourseService courseService;

    @PostConstruct
    private void start() throws Exception{
        addSampleUser();
        addSampleCourses();
        enrollStudentsToCourses1();
    }
    private void addSampleUser() throws Exception {
        authenticationService.register(
                new RegisterRequest(
                        "thej",
                        "fonseka",
                        "thej@gmail.com",
                        "123456",
                        Role.STUDENT
                )
        );
        authenticationService.register(
                new RegisterRequest(
                        "admin",
                        "fonseka",
                        "admin@gmail.com",
                        "123456",
                        Role.ADMIN
                )
        );authenticationService.register(
                new RegisterRequest(
                        "teach",
                        "fonseka",
                        "teach@gmail.com",
                        "123456",
                        Role.TEACHER
                )
        );
    }

    private void addSampleCourses() throws Exception {
        final String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        Course course1 = Course.builder()
                .courseCode("CS 0001")
                .name("OOP")
                .description(description)
                .build();
        courseService.createNewCourse(course1, "teach@gmail.com");

        Course course2 = Course.builder()
                .courseCode("CS 0002")
                .name("Algorithms")
                .description(description)
                .build();
        courseService.createNewCourse(course2, "teach@gmail.com");

    }

    private void enrollStudentsToCourses1() throws Exception {
        courseService.enrollStudent(1L, "thej@gmail.com");
        courseService.enrollStudent(2L, "thej@gmail.com");
    }

}
