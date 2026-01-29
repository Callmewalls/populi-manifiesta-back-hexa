package com.example.demo.user.application.ports.out;

import java.util.Optional;

import com.example.demo.user.domain.User;

public interface UserRepositoryPort {

    User save(User userUser);

    Optional<User> findById(Long id);
    
    Optional<User> findByMail(String email);

    Optional<User> findByMailWithRole(String mail);
}
