package com.thejan.lms.service;



import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;

import java.util.List;
import java.util.Set;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);    
    Course addStudentToCourse(Long studentId, Long courseId);
    List<Course> getCourses();
    Set<Student> getEnrolledStudents(Long id);
}