package com.thejan.lms.controller;

import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course) {
//        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String query) {
        return ResponseEntity.ok(courseService.search(query));
    }

//    @PutMapping("/{courseId}/student/{studentId}")
//    public ResponseEntity<Course> enrollStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
//        return new ResponseEntity<>(courseService.addStudentToCourse(studentId, courseId), HttpStatus.OK);
//    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getEnrolledStudents(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(courseService.getEnrolledStudents(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createNewCourse(
            @RequestBody Course course,
            Authentication authentication
    ) throws Exception {
        return ResponseEntity.ok(courseService.createNewCourse(course, authentication.getName()));
    }

    @PostMapping("/enroll/{id}")
    public ResponseEntity<?> enroll(@PathVariable Long id, Authentication authentication) throws Exception{
        return ResponseEntity.ok(courseService.enrollStudent(id, authentication.getName()));
    }

    @PostMapping("/unenroll/{id}")
    public void unenroll(@PathVariable Long id, Authentication authentication) throws Exception{
        courseService.unenrollStudent(id, authentication.getName());
    }
}