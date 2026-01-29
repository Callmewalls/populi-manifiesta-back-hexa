package com.example.demo.location_related.country.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location_related.country.application.ports.in.GetCountryUseCase;
import com.example.demo.location_related.country.application.ports.out.CountryRepositoryPort;
import com.example.demo.location_related.country.domain.Country;

@Service
public class CountryService implements GetCountryUseCase {

    private final CountryRepositoryPort countryRepositoryPort;

    public CountryService(CountryRepositoryPort countryRepositoryPort) {
        this.countryRepositoryPort = countryRepositoryPort;
    }

    @Override
    public Country getCountryById(Long countryId) {
        return countryRepositoryPort.findById(countryId)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @Override
    public List<Country> getAll() {
        return countryRepositoryPort.getAll();
    }

}
