package com.example.demo.location_related.state.infrastructure.in.web;

public record StateResponse(
    Long id,
    String code,
    String name,
    Long countryId) {
}