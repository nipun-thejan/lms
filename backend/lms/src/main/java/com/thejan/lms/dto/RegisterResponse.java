package com.thejan.lms.dto;

import com.thejan.lms.entity.Role;
import com.thejan.lms.entity.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
