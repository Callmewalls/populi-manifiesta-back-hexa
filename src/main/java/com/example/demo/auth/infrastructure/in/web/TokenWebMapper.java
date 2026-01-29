package com.example.demo.auth.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.auth.domain.TokenResponse;

@Mapper(componentModel = "spring")
public interface TokenWebMapper {

    TokenResponseWeb toWebResponse(TokenResponse tokenResponse);
}
