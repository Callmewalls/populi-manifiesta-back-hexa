package com.example.demo.user.infrastructure.in.web;

public record CreateUserRequest(
        String email,
        String password
) {}
