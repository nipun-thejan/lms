package com.thejan.lms.service;



import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.exception.CourseCreationFailureException;
import com.thejan.lms.exception.CourseEnrollmentFailedException;

import java.util.List;
import java.util.Set;

public interface CourseService {


    Course getCourseById(Long id) throws Exception;

    List<Course> getAllCourses();

    void deleteCourse(Long id);

    Object search(String query);

    List<Student> getEnrolledStudents(Long id) throws Exception;

    Course createNewCourse(Course course, String email) throws CourseCreationFailureException, Exception;

    Object enrollStudent(Long courseId, String email) throws CourseEnrollmentFailedException, Exception;

    void unenrollStudent(Long courseId, String email) throws Exception;
}