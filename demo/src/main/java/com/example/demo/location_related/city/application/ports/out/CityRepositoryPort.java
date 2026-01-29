package com.example.demo.location_related.city.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.demo.location_related.city.domain.City;

public interface CityRepositoryPort {
    
    Optional<City> findById(Long cityId);

    List<City> getAll();
}
