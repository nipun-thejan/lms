package com.thejan.lms.service;

import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Teacher;
import com.thejan.lms.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public List<Course> getConductingCourses(String email) {
        return getTeacher(email).getConductingCourses().stream().toList();
    }

    @Override
    public Teacher getTeacher(String email) {
        return teacherRepository.findTeacherByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("No teacher found with "+email)

        );
    }
}
