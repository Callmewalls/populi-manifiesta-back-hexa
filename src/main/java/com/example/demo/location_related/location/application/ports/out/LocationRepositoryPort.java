package com.example.demo.location_related.location.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.location_related.location.domain.Location;


public interface LocationRepositoryPort {
    
    Optional<Location> findById(Long locationId);
    
    List<Location> getAll();
    
    List<Location> findByIds(List<Long> ids);

    Location save(Location location);
}
