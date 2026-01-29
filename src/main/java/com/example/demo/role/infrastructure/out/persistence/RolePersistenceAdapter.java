package com.example.demo.role.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.role.application.ports.out.RoleRepositoryPort;
import com.example.demo.role.domain.Role;

@Component
public class RolePersistenceAdapter implements RoleRepositoryPort{

    JpaRoleRepository repository;
    RoleMapper mapper;

    public RolePersistenceAdapter(JpaRoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Role> findByRole(String role) {
        return repository.findByRoleName(role).map(mapper::toDomain);
    }

    @Override
    public Optional<Role> findById(Long roleId) {
        return repository.findById(roleId).map(mapper::toDomain);
    }
    
}
