package com.example.demo.location_related.city.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location_related.city.application.ports.in.GetCityUseCase;
import com.example.demo.location_related.city.application.ports.out.CityRepositoryPort;
import com.example.demo.location_related.city.domain.City;


@Service
public class CityService implements GetCityUseCase {

    private final CityRepositoryPort cityRepositoryPort;

    public CityService(CityRepositoryPort cityRepositoryPort) {
        this.cityRepositoryPort = cityRepositoryPort;
    }

    @Override
    public City getCityById(Long cityId) {
        return cityRepositoryPort.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }

    @Override
    public List<City> getAll() {
        return cityRepositoryPort.getAll();
    }

}
