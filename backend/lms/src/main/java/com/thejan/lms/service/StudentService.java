package com.thejan.lms.service;


import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
    Set<Course> getEnrolledCourses(Long id);
}