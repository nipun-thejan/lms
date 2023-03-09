package com.thejan.lms.controller;




import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getEnrolledCourses(Authentication authentication){
        return ResponseEntity.ok(studentService.getEnrolledCourses(authentication.getName()));
    }

//    @PostMapping
//    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
//        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

//    @GetMapping("/courses")
//    public ResponseEntity<List<Course>> getEnrolledCourses(@PathVariable Long id) {
//        return new ResponseEntity<>(studentService.getEnrolledCourses(id), HttpStatus.OK);
//    }

}
