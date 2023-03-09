package com.thejan.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    @JsonProperty("course_code")
    private String courseCode;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    @JsonIgnore
    public Set<StudentCourseRegistration> registrations = new HashSet<>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }




}
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Subject cannot be blank")
//    @NonNull
////    @Column(name = "subject", nullable = false)
//    private String name;
//
//    @NotBlank(message = "Course code cannot be blank")
//    @NonNull
//    @Column(name = "code", nullable = false)
//    private String code;
//
//    @NotBlank(message = "Description cannot be blank")
//    @NonNull
//    @Column(name = "description", nullable = false)
//    private String description;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<Grade> grades;
//
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//        name = "course_student",
//        joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
//    )
//    private Set<Student> students;