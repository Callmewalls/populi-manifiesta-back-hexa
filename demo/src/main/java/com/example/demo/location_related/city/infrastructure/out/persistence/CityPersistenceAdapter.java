package com.example.demo.location_related.city.infrastructure.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.location_related.city.application.ports.out.CityRepositoryPort;
import com.example.demo.location_related.city.domain.City;

@Component
public class CityPersistenceAdapter implements CityRepositoryPort{

    JpaCityRepository repository;
    CityMapper mapper;

    public CityPersistenceAdapter(JpaCityRepository repository, CityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<City> findById(Long cityId) {
        return repository.findById(cityId).map(mapper::toCity);
    }

    @Override
    public List<City> getAll() {
        return repository.findAll().stream().map(mapper::toCity).toList();
    }
    
}
