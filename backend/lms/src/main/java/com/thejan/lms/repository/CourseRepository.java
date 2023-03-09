package com.thejan.lms.repository;

import com.thejan.lms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByNameContainingIgnoreCase(String name);


}