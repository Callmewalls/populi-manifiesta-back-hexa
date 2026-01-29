package com.example.demo.auth.infrastructure.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.user.application.ports.out.UserRepositoryPort;

@Configuration
public class UserDetailsConfig {

    private final UserRepositoryPort userRepository;

    public UserDetailsConfig(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByMailWithRole(username)
                .map(user -> new CustomUserDetails(
                        user.getId(),
                        user.getEmail(),
                        user.getPassword(),
                        List.of(
                                new SimpleGrantedAuthority(
                                        "ROLE_" + user.getRole().getRole()))))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
