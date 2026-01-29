package com.example.demo.role.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.role.domain.Role;

@Mapper(componentModel="spring")
public interface RoleMapper{
    
    RoleEntity toEntity(Role role);

    Role toDomain(RoleEntity entity);
}
