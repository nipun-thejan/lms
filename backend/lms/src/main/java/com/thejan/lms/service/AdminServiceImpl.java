package com.thejan.lms.service;

import com.thejan.lms.dto.AuthenticationResponse;
import com.thejan.lms.dto.RegisterRequest;
import com.thejan.lms.dto.RegisterResponse;
import com.thejan.lms.entity.Role;
import com.thejan.lms.entity.User;
import com.thejan.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public RegisterResponse assignNewAdmin(RegisterRequest request) throws Exception {
        request.setRole(Role.ADMIN);
        return authenticationService.register(request);
    }
}
