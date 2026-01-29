package com.example.demo.location_related.city.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.location_related.city.domain.City;

@Mapper(componentModel="spring")
public interface CityMapper{
    
    CityEntity toEntity(City city);

    City toCity(CityEntity entity);
}
