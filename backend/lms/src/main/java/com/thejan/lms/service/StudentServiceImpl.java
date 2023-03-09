package com.thejan.lms.service;


import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.StudentCourseRegistration;
import com.thejan.lms.exception.EntityNotFoundException;
import com.thejan.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(
                        "No std found for"+ id
                )
        );
    }

    @Override
    public Student getStudent(String email) {
        return studentRepository.findStudentByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("No std found for "+ email)
                );

    }


    @Override
    public List<Course> getEnrolledCourses(Long id) {
        return getStudent(id)
                .getRegistrations()
                .stream()
                .map(StudentCourseRegistration::getCourse)
                .toList();

    }

    @Override
    public List<Course> getEnrolledCourses(String email) {
        return getStudent(email)
                .getRegistrations()
                .stream()
                .map(StudentCourseRegistration::getCourse)
                .toList();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Student.class);
    }

}