package com.example.demo.user.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.user.domain.User;

@Mapper(componentModel = "spring")
public interface UserWebMapper {

    UserResponse toResponse(User user);
}
