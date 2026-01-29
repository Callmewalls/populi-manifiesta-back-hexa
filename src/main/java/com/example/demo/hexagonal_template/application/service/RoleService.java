// package com.example.demo.role.application.service;

// import org.springframework.stereotype.Service;

// import com.example.demo.role.application.ports.in.GetRoleUseCase;
// import com.example.demo.role.application.ports.out.RoleRepositoryPort;
// import com.example.demo.role.domain.Role;
// import com.example.demo.role.infrastructure.out.persistence.RoleEntity;
// import com.example.demo.role.infrastructure.out.persistence.RoleMapper;

// 
// public class RoleService implements GetRoleUseCase {

//     private final RoleRepositoryPort roleRepositoryPort;
//     private final RoleMapper mapper;

//     public RoleService(RoleRepositoryPort roleRepositoryPort, RoleMapper mapper) {
//         this.roleRepositoryPort = roleRepositoryPort;
//         this.mapper = mapper;
//     }

//     @Override
//     public Role getRoleByName(String role) {
//         RoleEntity roleEntity = roleRepositoryPort.findByRole(role)
//                 .orElseThrow(() -> new RuntimeException("Role not found"));

//         return mapper.toDomain(roleEntity);
//     }

//     @Override
//     public Role getRoleById(Long roleId) {
//         RoleEntity roleEntity = roleRepositoryPort.findById(roleId)
//                 .orElseThrow(() -> new RuntimeException("Role not found"));

//         return mapper.toDomain(roleEntity);
//     }

// }
