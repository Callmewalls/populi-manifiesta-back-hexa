package com.example.demo.location_related.country.application.ports.in;

import java.util.List;

import com.example.demo.location_related.country.domain.Country;


public interface GetCountryUseCase {
    
    Country getCountryById(Long countryId);

    List<Country> getAll();
}
