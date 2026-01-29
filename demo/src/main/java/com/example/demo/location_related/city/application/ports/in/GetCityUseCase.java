package com.example.demo.location_related.city.application.ports.in;

import java.util.List;

import com.example.demo.location_related.city.domain.City;

public interface GetCityUseCase {
    
    City getCityById(Long cityId);

    List<City> getAll();
}
