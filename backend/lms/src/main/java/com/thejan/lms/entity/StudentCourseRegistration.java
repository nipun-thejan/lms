package com.thejan.lms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
public class StudentCourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    private Student student;

    @ManyToOne()
    private Course course;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate;

//    private Boolean enrolled;
}
