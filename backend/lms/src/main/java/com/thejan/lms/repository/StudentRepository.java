package com.thejan.lms.repository;

import com.thejan.lms.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}