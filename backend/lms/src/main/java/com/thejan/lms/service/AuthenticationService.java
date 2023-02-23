package com.thejan.lms.service;

import com.thejan.lms.utils.AuthenticationRequest;
import com.thejan.lms.utils.AuthenticationResponse;
import com.thejan.lms.utils.RegisterRequest;

public interface AuthenticationService {
    public AuthenticationResponse register(RegisterRequest request) throws Exception;
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws  Exception;
}
