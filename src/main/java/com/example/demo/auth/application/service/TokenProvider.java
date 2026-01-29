package com.example.demo.auth.application.service;

import com.example.demo.auth.domain.TokenResponse;


public interface TokenProvider {
    TokenResponse generateToken(Long userId, String email);
    boolean validateToken(String token);
    String getEmailFromToken(String token);
}

