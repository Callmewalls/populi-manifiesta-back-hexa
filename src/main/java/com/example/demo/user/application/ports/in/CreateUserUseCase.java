package com.example.demo.user.application.ports.in;

import com.example.demo.user.domain.User;

public interface CreateUserUseCase {
    User create(String email, String password);
    
    User createWithRole(String email, String password, String role);
}