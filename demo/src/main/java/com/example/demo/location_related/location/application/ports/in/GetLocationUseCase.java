package com.example.demo.location_related.location.application.ports.in;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.location_related.location.domain.Location;


public interface GetLocationUseCase {
    
    Location getLocationById(Long locationId);

    List<Location> getAll();

    List<Location> findByIds(List<Long> ids);
    
    Map<Long, Location> getLocationsForDate(LocalDate date);
}
