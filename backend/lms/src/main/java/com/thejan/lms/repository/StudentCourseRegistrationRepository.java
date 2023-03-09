package com.thejan.lms.repository;


import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.StudentCourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentCourseRegistrationRepository extends JpaRepository<StudentCourseRegistration, Long> {
    Optional<StudentCourseRegistration> findStudentCourseRegistrationByCourseAndStudent(
            Course course,
            Student student);
}
