package com.example.demo.user.application.service;

import org.springframework.stereotype.Service;

import com.example.demo.role.application.ports.in.GetRoleUseCase;
import com.example.demo.role.domain.Role;
import com.example.demo.user.application.ports.in.CreateUserUseCase;
import com.example.demo.user.application.ports.in.GetUserUseCase;
import com.example.demo.user.application.ports.out.UserRepositoryPort;
import com.example.demo.user.domain.User;

@Service
public class UserService implements CreateUserUseCase, GetUserUseCase {

    private final UserRepositoryPort userRepository; // puerto out
    private final GetRoleUseCase getRoleUseCase;      // puerto in

    public UserService(UserRepositoryPort userRepository, GetRoleUseCase getRoleUseCase) {
        this.userRepository = userRepository;
        this.getRoleUseCase = getRoleUseCase;
    }

    @Override
    public User create(String email, String password) {
        User user = new User(null, email, password, null);

        // Guardar usando el puerto de salida (repository)
        User saved = userRepository.save(user);

        return saved;
    }

    @Override
    public User createWithRole(String email, String password, String roleName) {
        // Obtener role usando el puerto in
        Role role = getRoleUseCase.getRoleByName(roleName);

        User user = new User(null, email, password, role);

        // Guardar usando el puerto de salida
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User getByMail(String email) {
        return userRepository.findByMail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

