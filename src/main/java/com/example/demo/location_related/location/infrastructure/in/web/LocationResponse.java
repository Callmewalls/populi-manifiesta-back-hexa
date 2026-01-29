package com.example.demo.location_related.location.infrastructure.in.web;

import java.math.BigDecimal;

public record LocationResponse(
    Long id,
    String name,
    BigDecimal latitude,
    BigDecimal longitude,
    Long cityId,
    String addressLabel) {
}