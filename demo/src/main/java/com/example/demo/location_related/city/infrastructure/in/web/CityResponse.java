package com.example.demo.location_related.city.infrastructure.in.web;

import java.math.BigDecimal;

public record CityResponse(
    Long id,
    String name,
    Long stateId,
    Long countryId,
    BigDecimal latitude,
    BigDecimal longitude
){}