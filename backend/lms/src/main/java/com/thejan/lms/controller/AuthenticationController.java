package com.thejan.lms.controller;

import com.thejan.lms.dto.RegisterResponse;
import com.thejan.lms.service.AuthenticationService;
import com.thejan.lms.dto.AuthenticationRequest;
import com.thejan.lms.dto.AuthenticationResponse;
import com.thejan.lms.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("/hi")
    public String hi() {
        return "Hellllo";
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) throws Exception{
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) throws Exception {
        return ResponseEntity.ok(
                authenticationService.logout(token.substring(7)));
    }
}