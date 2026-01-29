package com.example.demo.location_related.city.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCityRepository
        extends JpaRepository<CityEntity, Long> {

}
