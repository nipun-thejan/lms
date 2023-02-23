package com.thejan.lms.service;

import com.thejan.lms.entity.Token;
import com.thejan.lms.entity.User;
import com.thejan.lms.entity.UserFactory;
import com.thejan.lms.exception.EmailAlreadyExistsException;
import com.thejan.lms.repository.TokenRepository;
import com.thejan.lms.repository.UserRepository;
import com.thejan.lms.security.JwtService;
import com.thejan.lms.security.SecurityConstants;
import com.thejan.lms.utils.AuthenticationRequest;
import com.thejan.lms.utils.AuthenticationResponse;
import com.thejan.lms.utils.RegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegisterRequest request) throws Exception{
        try{
            request.validateRegisterRequest();
            System.out.println(request.getFirstName());

            User user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .build();

            var savedUser = userRepository.save(userFactory.getInstance(user));

            var jwtToken = jwtService.generateToken(user);

            saveUserToken(savedUser, jwtToken);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .user(user)
                    .build();

        }catch(DataIntegrityViolationException e){
            throw new EmailAlreadyExistsException("Your email address is already in use.");
        }catch(Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            System.out.println(request.getEmail());
            User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
            System.out.println("user"+ user.getEmail());
            var jwtToken = jwtService.generateToken(user);

            revokeAllUserTokens(user);
            saveUserToken(user, jwtToken);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .user(user)
                    .build();

        }catch(BadCredentialsException e) {
            throw new UsernameNotFoundException("Email or password is incorrect.");
        }catch(Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(SecurityConstants.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setRevoked(true);
            token.setExpired(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}

