package com.example.demo.location_related.location.infrastructure.out.persistence;

import org.mapstruct.Mapper;

import com.example.demo.location_related.location.domain.Location;


@Mapper(componentModel="spring")
public interface LocationMapper{
    
    LocationEntity toEntity(Location location);

    Location toLocation(LocationEntity entity);
}
