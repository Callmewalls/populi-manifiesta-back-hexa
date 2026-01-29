// package com.example.demo.role.infrastructure.out.persistence;

// import java.util.Optional;

// import org.springframework.stereotype.Component;

// import com.example.demo.role.application.ports.out.RoleRepositoryPort;

// @Component
// public class RolePersistenceAdapter implements RoleRepositoryPort{

//     JpaRoleRepository repository;

//     public RolePersistenceAdapter(JpaRoleRepository repository){
//         this.repository = repository;
//     }

//     @Override
//     public Optional<RoleEntity> findByRole(String role) {
//         return repository.findByRoleName(role);
//     }

//     @Override
//     public Optional<RoleEntity> findById(Long roleId) {
//         return repository.findById(roleId);
//     }
    
// }
