package com.example.demo.location_related.location.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.location_related.location.domain.Location;


@Mapper(componentModel = "spring")
public interface LocationWebMapper {
    
    LocationResponse toResponse(Location location);

    LocationMapMarkerResponse toMapMarkerResponse(Location location);
}
