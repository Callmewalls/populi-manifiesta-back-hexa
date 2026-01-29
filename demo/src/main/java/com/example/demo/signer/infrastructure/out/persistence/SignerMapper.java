package com.example.demo.signer.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.signer.domain.Signer;

@Mapper(componentModel="spring")
public interface SignerMapper{
    
    SignerEntity toEntity(Signer signer);

    Signer toDomain(SignerEntity entity);
}
