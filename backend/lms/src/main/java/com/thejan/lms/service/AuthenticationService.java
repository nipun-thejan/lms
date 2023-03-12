package com.thejan.lms.service;

import com.thejan.lms.dto.AuthenticationRequest;
import com.thejan.lms.dto.AuthenticationResponse;
import com.thejan.lms.dto.RegisterRequest;
import com.thejan.lms.dto.RegisterResponse;
import com.thejan.lms.exception.TokenNotFoundException;

public interface AuthenticationService {
    public RegisterResponse register(RegisterRequest request) throws Exception;

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws  Exception;

    String logout(String substring) throws TokenNotFoundException;
}
