package com.example.demo.location_related.country.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCountryRepository
        extends JpaRepository<CountryEntity, Long> {

}
