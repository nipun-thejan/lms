package com.thejan.lms.service;

import com.thejan.lms.dto.RegisterRequest;
import com.thejan.lms.entity.UserFactory;
import com.thejan.lms.repository.AdminRepository;
import com.thejan.lms.repository.StudentRepository;
import com.thejan.lms.repository.TeacherRepository;
import com.thejan.lms.repository.UserRepository;
import com.thejan.lms.security.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock private StudentRepository studentRepository;
    @Mock private TeacherRepository teacherRepository;
    @Mock private AdminRepository adminRepository;
    @Mock private UserFactory userFactory;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private JwtService jwtService;
    @Mock private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationService authenticationService;

    @Test
    public void Given_ARegistrationRequest_When_RegisterIsCalled_Then_ShouldRegisterUser() {
        // Given - Arrange
//        RegisterRequest registerRequest = RegisterRequest.builder()
//                .firstName()
//                .lastName()
//                .email()
//                .role()
//                .password()
//                .build();
// When - Act
// Then - Assert/Verify
    }


}
