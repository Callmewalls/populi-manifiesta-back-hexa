package com.example.demo.signer.infrastructure.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.signer.application.ports.in.GetSignerUseCase;

@RestController
@RequestMapping("/signers")
public class SignerController {
        
    private final SignerWebMapper mapper;
    private final GetSignerUseCase getCase;
    
    public SignerController(SignerWebMapper mapper, GetSignerUseCase getCase) {
        this.mapper = mapper;
        this.getCase = getCase;
    }

    @GetMapping("/findByUserId/{userId}")
    public SignerResponse findByUserId(@PathVariable Long userId){
        return mapper.toResponse(getCase.getSignerByUserId(userId));
    }
    
}
