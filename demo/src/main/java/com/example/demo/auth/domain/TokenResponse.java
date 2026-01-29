package com.example.demo.auth.domain;

public class TokenResponse {
    private final String token;
    private final long expiresAt; // timestamp

    public TokenResponse(String token, long expiresAt) {
        this.token = token;
        this.expiresAt = expiresAt;
    }

    public String getToken() {
        return token;
    }

    public long getExpiresAt() {
        return expiresAt;
    }
}
