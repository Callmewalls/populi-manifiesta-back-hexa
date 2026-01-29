package com.example.demo.role.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaRoleRepository
        extends JpaRepository<RoleEntity, Long> {

    @Query("Select e from RoleEntity e where e.role=:role")
    public Optional<RoleEntity> findByRoleName(String role);
}
