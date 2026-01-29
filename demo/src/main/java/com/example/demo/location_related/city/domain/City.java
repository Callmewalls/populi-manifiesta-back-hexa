package com.example.demo.location_related.city.domain;

import java.math.BigDecimal;

import com.example.demo.common.domain.BaseLongDomain;

public class City extends BaseLongDomain {
    private final String name;
    private final Long stateId; // opcional
    private final Long countryId;
    private final BigDecimal latitude;
    private final BigDecimal longitude;

    public City(String name, Long stateId, Long countryId,
            BigDecimal latitude, BigDecimal longitude) {
        this.name = name;
        this.stateId = stateId;
        this.countryId = countryId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public Long getStateId() {
        return stateId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
}
