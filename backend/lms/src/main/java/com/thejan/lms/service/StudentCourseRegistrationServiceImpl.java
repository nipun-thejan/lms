package com.thejan.lms.service;

import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.StudentCourseRegistration;
import com.thejan.lms.repository.StudentCourseRegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentCourseRegistrationServiceImpl implements StudentCourseRegistrationService {
    private final StudentCourseRegistrationRepository studentCourseRegistrationRepository;

    @Override
    public StudentCourseRegistration save(StudentCourseRegistration registration) {
        return studentCourseRegistrationRepository.save(registration);
    }

    @Override
    public StudentCourseRegistration getRegistration(Course course, Student student) {
        return studentCourseRegistrationRepository.findStudentCourseRegistrationByCourseAndStudent(course, student).orElseThrow();
    }

    @Override
    public void delete(StudentCourseRegistration registration) {
        studentCourseRegistrationRepository.delete(registration);

    }
}
