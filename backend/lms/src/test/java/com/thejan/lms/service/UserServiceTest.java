package com.thejan.lms.service;

import com.thejan.lms.entity.Role;
import com.thejan.lms.entity.Student;
import com.thejan.lms.entity.User;
import com.thejan.lms.entity.UserFactory;
import com.thejan.lms.repository.UserRepository;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFactory userFactory;

    @Test
    public void test_Given_AUserANDEmail_When_GetUserIsCalled_Then_ReturnUser() {
        // Given - Arrange
        String email = "thej@gamil.com";
        User user = User.builder()
                .firstName("thej")
                .lastName("fon")
                .email(email)
                .password("123456")
                .role(Role.STUDENT)
                .build();
        // When - Act
        when(userRepository.findUserByEmail(email)).thenReturn(Optional.ofNullable(user));
        when(userFactory.getInstance(any())).thenReturn(
                new Student(user)
        );
        User resultUser = userService.getUser(email);
    // Then - Assert/Verify
        assertEquals(email, resultUser.getEmail());
    }
}
