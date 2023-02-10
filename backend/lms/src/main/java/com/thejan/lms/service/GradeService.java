package com.thejan.lms.service;



import com.thejan.lms.entity.Grade;

import java.util.List;

public interface GradeService {
    Grade getGrade(Long studentId, Long courseId);
    Grade saveGrade(Grade grade, Long studentId, Long courseId);
    Grade updateGrade(String score, Long studentId, Long courseId);
    void deleteGrade(Long studentId, Long courseId);
    List<Grade> getStudentGrades(Long studentId);
    List<Grade> getCourseGrades(Long courseId);
    List<Grade> getAllGrades();
}
