package com.example.demo.signer.infrastructure.in.web;

import java.time.LocalDate;

public record SignerResponse(
    String nif,
    String name,
    String lastNames,
    LocalDate birthDate,
    Long userId
){}