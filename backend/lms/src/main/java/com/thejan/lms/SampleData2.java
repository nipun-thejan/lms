package com.thejan.lms;

import com.thejan.lms.entity.Course;
import com.thejan.lms.service.AuthenticationService;
import com.thejan.lms.service.CourseService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
//@Component
public class SampleData2 {
    private final AuthenticationService authenticationService;
    private final CourseService courseService;


//    @PostConstruct
//    private void addSampleUser() throws Exception {
//        authenticationService.register(
//                new RegisterRequest(
//                        "thej",
//                        "fonseka",
//                        "thej@gmail.com",
//                        "123456",
//                        Role.STUDENT
//                )
//        );
//        authenticationService.register(
//                new RegisterRequest(
//                        "admin",
//                        "fonseka",
//                        "admin@gmail.com",
//                        "123456",
//                        Role.ADMIN
//                )
//        );authenticationService.register(
//                new RegisterRequest(
//                        "teach",
//                        "fonseka",
//                        "teach@gmail.com",
//                        "123456",
//                        Role.TEACHER
//                )
//        );
//    }

//    @PostConstruct
//    private void addSampleCourses() throws Exception {
//        final String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vitae ante convallis nunc aliquam mattis. Etiam non nisl id elit auctor porta. Vestibulum scelerisque diam at mauris pretium, non aliquam ligula pharetra. Proin pharetra enim eget rhoncus euismod. Suspendisse lacinia eleifend tempus. Pellentesque vulputate efficitur hendrerit. Nam hendrerit lacus diam, vel finibus diam hendrerit vel. Aliquam commodo tortor massa, nec rutrum tortor tristique sed. Phasellus ullamcorper volutpat turpis sit amet venenatis. Aenean sed aliquet quam, ut porttitor augue. Fusce egestas auctor tortor sit amet placerat. Suspendisse potenti. Donec sit amet est metus. Proin consectetur nisi volutpat rutrum viverra. Maecenas facilisis eros non libero volutpat ullamcorper. Aliquam posuere felis in metus rhoncus, eget scelerisque mauris ultrices. ";
//        Course course1 = Course.builder()
//                .courseCode("CS 0001")
//                .name("OOP")
//                .description(description)
//                .build();
//        courseService.createNewCourse(course1, "teach@gmail.com");
//
//        Course course2 = Course.builder()
//                .courseCode("CS 0002")
//                .name("Algorithms")
//                .description(description)
//                .build();
//        courseService.createNewCourse(course2, "teach@gmail.com");
//
//    }
//    @PostConstruct
//    private void enrollStudentsToCourses() throws Exception {
//        courseService.enrollStudent(1L, "thej@gmail.com");
//        courseService.enrollStudent(2L, "thej@gmail.com");
//    }

}
