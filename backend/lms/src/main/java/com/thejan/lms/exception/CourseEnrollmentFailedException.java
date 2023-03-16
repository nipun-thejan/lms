package com.thejan.lms.exception;

public class CourseEnrollmentFailedException extends RuntimeException
{
    public CourseEnrollmentFailedException(String message) {
        super(message);
    }
}
