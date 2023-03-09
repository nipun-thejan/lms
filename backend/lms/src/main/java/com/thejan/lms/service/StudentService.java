package com.thejan.lms.service;


import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {
    Student getStudent(Long id);
    Student getStudent(String email);
    List<Course> getEnrolledCourses(Long id);
    List<Course> getEnrolledCourses(String email);
    List<Student> getStudents();
}