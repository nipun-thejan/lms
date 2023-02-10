package com.thejan.lms.repository;

import com.thejan.lms.entity.Course;
import org.springframework.data.repository.CrudRepository;


public interface CourseRepository extends CrudRepository<Course, Long> {

}