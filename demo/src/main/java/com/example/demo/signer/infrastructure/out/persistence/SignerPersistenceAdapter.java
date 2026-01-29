package com.example.demo.signer.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.signer.application.ports.out.SignerRepositoryPort;
import com.example.demo.signer.domain.Signer;

@Component
public class SignerPersistenceAdapter implements SignerRepositoryPort{

    JpaSignerRepository repository;
    SignerMapper mapper;

    public SignerPersistenceAdapter(JpaSignerRepository repository, SignerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Signer> findBySigner(String signer) {
        return repository.findBySignerName(signer).map(mapper::toDomain);
    }

    @Override
    public Optional<Signer> findById(Long signerId) {
        return repository.findById(signerId).map(mapper::toDomain);
    }

    @Override
    public Optional<Signer> findByUserId(Long userId) {
        return repository.findByUserId(userId).map(mapper::toDomain);
    }

    
}
