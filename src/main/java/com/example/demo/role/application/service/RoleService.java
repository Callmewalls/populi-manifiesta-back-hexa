package com.example.demo.role.application.service;

import org.springframework.stereotype.Service;

import com.example.demo.role.application.ports.in.GetRoleUseCase;
import com.example.demo.role.application.ports.out.RoleRepositoryPort;
import com.example.demo.role.domain.Role;


@Service
public class RoleService implements GetRoleUseCase {

    private final RoleRepositoryPort roleRepositoryPort;

    public RoleService(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public Role getRoleByName(String role) {
        return roleRepositoryPort.findByRole(role)
                .orElseThrow(() -> new RuntimeException("Role not found"));

    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepositoryPort.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

}
