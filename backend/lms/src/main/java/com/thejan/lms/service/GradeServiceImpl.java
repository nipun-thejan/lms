package com.thejan.lms.service;


import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Grade;
import com.thejan.lms.entity.Student;
import com.thejan.lms.exception.GradeNotFoundException;
import com.thejan.lms.exception.StudentNotEnrolledException;
import com.thejan.lms.repository.CourseRepository;
import com.thejan.lms.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;
    private CourseRepository courseRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
         Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
         return unwrapGrade(grade, studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
//        Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
//        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
//        if (!student.getCourses().contains(course)) throw new StudentNotEnrolledException(studentId, courseId);
//        grade.setStudent(student);
//        grade.setCourse(course);
        return null;
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        Grade unwrappedGrade = unwrapGrade(grade, studentId, courseId);
        unwrappedGrade.setScore(score);
        return gradeRepository.save(unwrappedGrade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

    static Grade unwrapGrade(Optional<Grade> entity, Long studentId, Long courseId) {
        if (entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(studentId, courseId);
    }

}
