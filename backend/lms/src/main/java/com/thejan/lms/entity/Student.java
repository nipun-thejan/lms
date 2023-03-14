package com.thejan.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student extends User{

//    private String major;

    public Student(User user) {
        super(user);
    }

//    @JsonIgnore
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private List<Grade> grades;
//
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//        name = "course_student",
//        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
//    )
//    private Set<Course> courses;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<StudentCourseRegistration> registrations;

}
