package com.example.demo.signer.application.ports.in;

import com.example.demo.signer.domain.Signer;

public interface GetSignerUseCase {
    
    Signer getSignerById(Long id);

    Signer getSignerByName(String name);
    
    Signer getSignerByUserId(Long id);
}
