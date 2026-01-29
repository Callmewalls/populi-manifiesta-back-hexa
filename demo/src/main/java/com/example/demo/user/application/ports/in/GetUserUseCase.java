package com.example.demo.user.application.ports.in;

import com.example.demo.user.domain.User;

public interface GetUserUseCase {
    User getById(Long id);
    
    User getByMail(String email);
}
