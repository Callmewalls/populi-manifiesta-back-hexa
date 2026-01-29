package com.example.demo.role.application.ports.in;

import com.example.demo.role.domain.Role;

public interface GetRoleUseCase {
    
    Role getRoleById(Long roleId);

    Role getRoleByName(String role);
}
