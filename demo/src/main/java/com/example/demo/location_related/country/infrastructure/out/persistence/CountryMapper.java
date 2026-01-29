package com.example.demo.location_related.country.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.location_related.country.domain.Country;

@Mapper(componentModel="spring")
public interface CountryMapper{
    
    CountryEntity toEntity(Country country);

    Country toCountry(CountryEntity entity);
}
