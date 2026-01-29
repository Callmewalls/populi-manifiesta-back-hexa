package com.example.demo.auth.infrastructure.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.user.application.ports.out.UserRepositoryPort;
import com.example.demo.user.domain.User;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepositoryPort userRepository;

    public CustomUserDetailsService(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) {
        return userRepository.findByMailWithRole(email)
                .map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public CustomUserDetails loadUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private CustomUserDetails toUserDetails(User user) {
        return new CustomUserDetails(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(
                        "ROLE_" + user.getRole().getRole())));
    }

}
