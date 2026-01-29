package com.example.demo.auth.application.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.auth.application.ports.in.LoginUseCase;
import com.example.demo.auth.domain.Credentials;
import com.example.demo.auth.domain.TokenResponse;
import com.example.demo.auth.infrastructure.jwt.JwtService;
import com.example.demo.user.application.ports.out.UserRepositoryPort;
import com.example.demo.user.domain.User;

@Service
public class AuthService implements LoginUseCase {
    
    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepositoryPort userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse login(Credentials credentials) {
        User user = userRepository.findByMail(credentials.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        TokenResponse token = jwtService.generateToken(user.getId(), user.getEmail());

        return token;
    }
}
