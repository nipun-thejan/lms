package com.thejan.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "teacher")
//@PrimaryKeyJoinColumn(name = "teacherId")
public class Teacher extends User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;
    private String department;
    public Teacher(User user) {
        super(user);
        department="cse";
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Course> conductingCourses = new HashSet<>();

}
