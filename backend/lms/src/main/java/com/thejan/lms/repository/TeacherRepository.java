package com.thejan.lms.repository;

import com.thejan.lms.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@PreAuthorize("hasAuthority('TEACHER')")
public interface TeacherRepository extends UserBaseRepository<Teacher> {
    Optional<Teacher> findTeacherByEmail(String email);
}
