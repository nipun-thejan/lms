package com.thejan.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
//@PrimaryKeyJoinColumn(name = "teacherId")
public class Teacher extends User {

    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Course> conductingCourses;

    public Teacher(User user) {
        super(user);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
