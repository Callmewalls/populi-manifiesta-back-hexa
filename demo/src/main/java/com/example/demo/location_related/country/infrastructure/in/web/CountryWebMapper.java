package com.example.demo.location_related.country.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.location_related.country.domain.Country;


@Mapper(componentModel = "spring")
public interface CountryWebMapper {
    
    CountryResponse toResponse(Country country);
}
