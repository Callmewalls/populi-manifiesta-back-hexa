package com.example.demo.location_related.city.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.location_related.city.domain.City;

@Mapper(componentModel = "spring")
public interface CityWebMapper {
    
    CityResponse toResponse(City city);
}
