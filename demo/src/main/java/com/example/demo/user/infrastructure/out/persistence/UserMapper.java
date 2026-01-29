package com.example.demo.user.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.user.domain.User;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);
}
