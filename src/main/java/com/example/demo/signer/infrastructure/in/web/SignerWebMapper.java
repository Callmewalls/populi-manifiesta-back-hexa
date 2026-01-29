package com.example.demo.signer.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.signer.domain.Signer;

@Mapper(componentModel = "spring")
public interface SignerWebMapper {
    
    SignerResponse toResponse(Signer signer);
}
