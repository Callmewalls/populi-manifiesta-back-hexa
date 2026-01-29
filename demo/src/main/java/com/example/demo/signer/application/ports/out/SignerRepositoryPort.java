package com.example.demo.signer.application.ports.out;

import java.util.Optional;

import com.example.demo.signer.domain.Signer;

public interface SignerRepositoryPort {
    
    Optional<Signer> findById(Long id);

    Optional<Signer> findBySigner(String name);
    
    Optional<Signer> findByUserId(Long id);
}
