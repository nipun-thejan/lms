package com.thejan.lms.controller;

import com.thejan.lms.entity.Course;
import com.thejan.lms.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getConducting(Authentication authentication) {
        return ResponseEntity.ok(teacherService.getConductingCourses(authentication.getName()));
    }
}
