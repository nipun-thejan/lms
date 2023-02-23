package com.thejan.lms.entity;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student extends User{

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

}
