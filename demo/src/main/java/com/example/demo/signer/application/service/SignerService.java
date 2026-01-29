package com.example.demo.signer.application.service;

import org.springframework.stereotype.Service;

import com.example.demo.signer.application.ports.in.GetSignerUseCase;
import com.example.demo.signer.application.ports.out.SignerRepositoryPort;
import com.example.demo.signer.domain.Signer;


@Service
public class SignerService implements GetSignerUseCase {

    private final SignerRepositoryPort signerRepositoryPort;

    public SignerService(SignerRepositoryPort signerRepositoryPort) {
        this.signerRepositoryPort = signerRepositoryPort;
    }

    @Override
    public Signer getSignerByName(String signer) {
        return signerRepositoryPort.findBySigner(signer)
                .orElseThrow(() -> new RuntimeException("Signer not found"));
    }

    @Override
    public Signer getSignerById(Long signerId) {
        return signerRepositoryPort.findById(signerId)
                .orElseThrow(() -> new RuntimeException("Signer not found"));
    }

    @Override
    public Signer getSignerByUserId(Long userId) {
        return signerRepositoryPort.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Signer not found"));
    }

}
