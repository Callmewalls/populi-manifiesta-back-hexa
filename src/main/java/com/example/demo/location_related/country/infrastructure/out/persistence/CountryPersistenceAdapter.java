package com.example.demo.location_related.country.infrastructure.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.location_related.country.application.ports.out.CountryRepositoryPort;
import com.example.demo.location_related.country.domain.Country;


@Component
public class CountryPersistenceAdapter implements CountryRepositoryPort{

    JpaCountryRepository repository;
    CountryMapper mapper;

    public CountryPersistenceAdapter(JpaCountryRepository repository, CountryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Country> findById(Long countryId) {
        return repository.findById(countryId).map(mapper::toCountry);
    }

    @Override
    public List<Country> getAll() {
        return repository.findAll().stream().map(mapper::toCountry).toList();
    }
    
}
