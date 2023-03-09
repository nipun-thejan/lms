package com.thejan.lms;

import com.thejan.lms.entity.Role;
import com.thejan.lms.service.AuthenticationService;
import com.thejan.lms.service.CourseService;
import com.thejan.lms.dto.RegisterRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SampleData {
    private final AuthenticationService authenticationService;
    private final CourseService courseService;


    @PostConstruct
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

    @PostConstruct
    private void addSampleCourses() throws Exception {

    }
    @PostConstruct
    private void enrollStudentsToCourses() throws Exception {
//        courseService.enrollStudent(1, "nsadisha@gmail.com");
//        courseService.enrollStudent(3, "nsadisha@gmail.com");
    }

}
