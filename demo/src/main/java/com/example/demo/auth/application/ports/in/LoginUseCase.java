package com.example.demo.auth.application.ports.in;

import com.example.demo.auth.domain.Credentials;
import com.example.demo.auth.domain.TokenResponse;

public interface LoginUseCase {
    
    TokenResponse login(Credentials credentials);
}
