package com.example.demo.location_related.country.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.location_related.country.domain.Country;

public interface CountryRepositoryPort {
    
    Optional<Country> findById(Long countryId);
    
    List<Country> getAll();
}
