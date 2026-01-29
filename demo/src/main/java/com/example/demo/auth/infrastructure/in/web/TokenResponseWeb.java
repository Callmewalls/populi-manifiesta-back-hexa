package com.example.demo.auth.infrastructure.in.web;

public record TokenResponseWeb(String token, long expiresAt) {}
