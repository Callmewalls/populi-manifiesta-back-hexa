package com.example.demo.location_related.location.infrastructure.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.location_related.location.application.ports.out.LocationRepositoryPort;
import com.example.demo.location_related.location.domain.Location;

@Component
public class LocationPersistenceAdapter implements LocationRepositoryPort{

    JpaLocationRepository repository;
    LocationMapper mapper;

    public LocationPersistenceAdapter(JpaLocationRepository repository, LocationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Location> findById(Long locationId) {
        return repository.findById(locationId).map(mapper::toLocation);
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll().stream().map(mapper::toLocation).toList();
    }

    @Override
    public List<Location> findByIds(List<Long> ids) {
        return repository.findByIds(ids).stream().map(mapper::toLocation).toList();
    }

    @Override
    public Location save(Location location) {
        return mapper.toLocation(
            repository.save(mapper.toEntity(location))
        );
    }
    
}