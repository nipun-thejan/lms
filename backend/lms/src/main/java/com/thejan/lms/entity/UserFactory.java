package com.thejan.lms.entity;

import org.springframework.stereotype.Service;

@Service
public class UserFactory {
    public User getInstance(User user) {
        switch (user.getRole()) {
            case STUDENT -> {
                return new Student(user);
            }
            case TEACHER -> {
                return new Teacher(user);
            }
            case ADMIN -> {
                return new Admin(user);
            }
            default -> {
                return user;
            }
        }
    }
}

