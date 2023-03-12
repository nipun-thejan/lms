package com.thejan.lms.repository;

import com.thejan.lms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface StudentRepository extends UserBaseRepository<Student> {
    Optional<Student> findStudentByEmail(String email);
}
