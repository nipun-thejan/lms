package com.thejan.lms.service;

import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.StudentCourseRegistration;

public interface StudentCourseRegistrationService {
    StudentCourseRegistration save(StudentCourseRegistration registration);

    StudentCourseRegistration getRegistration(Course course, Student student);

    void delete(StudentCourseRegistration registration);
}
