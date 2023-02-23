package com.thejan.lms.utils;

import com.thejan.lms.entity.Role;
import com.thejan.lms.exception.EmptyRequestValueException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    public void validateRegisterRequest() throws Exception {
        if (isEmpty(firstName)) {
            throw new EmptyRequestValueException("First name is null or empty.");
        } else if (isEmpty(lastName)) {
            throw new EmptyRequestValueException("Last name is null or empty.");
        } else if (isEmpty(email)) {
            throw new EmptyRequestValueException("Email is null or empty.");
        } else if (isEmpty(password)) {
            throw new EmptyRequestValueException("Password is null or empty.");
        } else if (isEmpty(role.name())) {
            throw new EmptyRequestValueException("Role is null or empty.");
        }
    }

    private boolean isEmpty(String field) {
        return field == null || field.isEmpty();
    }
}