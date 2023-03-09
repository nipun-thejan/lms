package com.thejan.lms.service;

import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Course> getConductingCourses(String email);
    
    Teacher getTeacher(String email);
}
