package com.example.demo.role.application.ports.out;

import java.util.Optional;

import com.example.demo.role.domain.Role;

public interface RoleRepositoryPort {
    
    Optional<Role> findByRole(String role);
    
    Optional<Role> findById(Long roleId);
}
