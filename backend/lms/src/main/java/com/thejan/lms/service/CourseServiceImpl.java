package com.thejan.lms.service;


import com.thejan.lms.entity.Course;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.StudentCourseRegistration;
import com.thejan.lms.entity.Teacher;
import com.thejan.lms.exception.CourseCreationFailureException;
import com.thejan.lms.exception.CourseEnrollmentFailedException;
import com.thejan.lms.exception.CourseNotFoundException;
import com.thejan.lms.exception.EntityNotFoundException;
import com.thejan.lms.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TeacherService teacherService;

    private final StudentService studentService;

    private final StudentCourseRegistrationService studentCourseRegisterService;

//    @Override
//    public Course getCourse(Long id) {
//        Optional<Course> course = courseRepository.findById(id);
//        return unwrapCourse(course, id);
//    }



    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Course.class);
    }


    @Override
    public Course getCourseById(Long id) throws Exception {
        return courseRepository.findById(id).orElseThrow(
                () -> new CourseNotFoundException("Cannot find a course with id: "+id)
        );
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {

    }

    @Override
    public Object search(String query) {
        return courseRepository.findCoursesByNameContainingIgnoreCase(query);
    }

    @Override
    public List<Student> getEnrolledStudents(Long courseId) throws Exception {
        Course course = getCourseById(courseId);
        return course.getRegistrations().stream().map(StudentCourseRegistration::getStudent).toList();
    }

    @Override
    public Course createNewCourse(Course course, String email) throws Exception {
        try {
            Teacher teacher = teacherService.getTeacher(email);
            course.setTeacher(teacher);
            teacher.getConductingCourses().add(course);
            return courseRepository.save(course);
        } catch(DataIntegrityViolationException e) {
            throw new CourseCreationFailureException("Cannot create a new course with already existing course code.");
        } catch(Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    @Override
    public StudentCourseRegistration enrollStudent(Long courseId, String email) throws Exception {
        try{
            Student student = studentService.getStudent(email);
            Course course = getCourseById(courseId);
            StudentCourseRegistration registration = StudentCourseRegistration
                    .builder()
                    .student(student)
                    .course(course)
                    .registrationDate(LocalDateTime.now())
                    .build();
            student.getRegistrations().add(registration);
            course.getRegistrations().add(registration);
            return studentCourseRegisterService.save(registration);
        }catch(DataIntegrityViolationException e) {
            throw new CourseEnrollmentFailedException("You have already enrolled in this course.");
        }catch(Exception e) {
            throw new CourseEnrollmentFailedException(e.getLocalizedMessage());
        }    }

    @Override
    public void unenrollStudent(Long courseId, String email) throws Exception {
        Student student = studentService.getStudent(email);
        Course course = getCourseById(courseId);
        StudentCourseRegistration registration = studentCourseRegisterService.getRegistration(course, student);

        studentCourseRegisterService.delete(registration);
        student.getRegistrations().remove(registration);
        course.getRegistrations().remove(registration);
        //TODO: impl boolean enrolled and not delete
    }
}
